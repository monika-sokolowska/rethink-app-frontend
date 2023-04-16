import "./News.css";
import React, { useState } from "react";
import data from "./data";
import NewsBlock from "./NewsBlock/NewsBlock";

const News = () => {
  const [news, setNews] = useState(data);

  return (
    <section className="news">
      {news.map((item) => {
        const { id, title, image, text } = item;
        return (
          <div key={id} className="news-wrapper">
            <NewsBlock title={title} image={image} text={text} />;
          </div>
        );
      })}
    </section>
  );
};
export default News;
