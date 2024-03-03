import codecs
import html
import json
from flask import Flask, jsonify, request
from urllib.request import Request, urlopen
from bs4 import BeautifulSoup
import re

app = Flask(__name__)

def cleanse_unicode(s):
      single_quote_expr = re.compile(r'[\u2018\u2019]', re.U)

      unicode_chars_expr = re.compile(r'[\u0080-\uffff]', re.U)

      dot_operator_expr = re.compile(r'\u22c5', re.U)
      if not s:
         return ""
    
      temp = single_quote_expr.sub("'", s, re.U)
      temp = unicode_chars_expr.sub("", temp, re.U)
      temp = dot_operator_expr.sub(".", temp)
      return temp

@app.route('/scrape-url', methods=['POST'])
def scrape_url():
    url_input = request.json.get('url')
    print("url", url_input)
    
    req = Request(url=url_input, headers={'User-Agent': 'Mozilla/5.0'})
    page = urlopen(req)
    soup = BeautifulSoup(page.read().decode("utf-8"), "html.parser")

    content = soup.find_all("section")

    extracted_text = []
    for item in content:
        paragraphs = item.find_all("p")
        for p in paragraphs:
            clean_text = re.sub("<.*?>", "", str(p))
            cleaned_text = re.sub(r'\n', '', str(clean_text))
            extracted_text.append(cleaned_text.strip())

    extracted_text = ' '.join(extracted_text)

    extracted_text = cleanse_unicode(extracted_text)

    return jsonify({'extracted_text': extracted_text})

if __name__ == '__main__':
    app.run(debug=True)