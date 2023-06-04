import "./NewsAdmin.css";
import React, { useState } from "react";
import NewsBlockAdmin from "./NewsBlockAdmin/NewsBlockAdmin";
import { useSelector, useDispatch } from "react-redux";
import { useEffect } from "react";
import { getAllArticles } from "../../../reducers/allArticlesSlice";
import ArticleModalAdmin from "./ArticleModalAdmin/ArticleModalAdmin";

const NewsAdmin = () => {
  const { articles } = useSelector((store) => store.articles);
  const dispatch = useDispatch();
  const [showModal, setShowModal] = useState(false);
  const [articleDescription, setArticleDescription] = useState("");
  const [articleTitle, setArticleTitle] = useState("");

  useEffect(() => {
    dispatch(getAllArticles());
  }, []);

  const openModal = (id_article) => {
    console.log("id", id_article);
    const article = articles.find((a) => a.id_article === id_article);
    console.log("article", article);
    setArticleDescription(article.text);
    setArticleTitle(article.title);
    setShowModal(true);
  };

  const handleModalClose = () => {
    setShowModal(false);
  };

  return (
    <section className="news">
      <ArticleModalAdmin
        isOpen={showModal}
        handleClose={handleModalClose}
        title={articleTitle}
        description={articleDescription}
      />
      {articles.map((item) => {
        const { id_article, title, image } = item;
        console.log(item);
        return (
          <div key={id_article} className="news-wrapper">
            <NewsBlockAdmin
              title={title}
              image={image}
              openModal={() => openModal(id_article)}
            />
            ;
          </div>
        );
      })}
    </section>
  );
};
export default NewsAdmin;
