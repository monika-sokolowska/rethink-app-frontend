import "./News.css";
import React, { useState } from "react";
// import data from "./data";
import NewsBlock from "./NewsBlock/NewsBlock";
import { useSelector, useDispatch } from "react-redux";
import { useEffect } from "react";
import { getAllArticles } from "../../../reducers/allArticlesSlice";

const News = () => {
  const { articles } = useSelector((store) => store.articles);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllArticles());
  }, []);

  return (
    <section className="news">
      {articles.map((item) => {
        const { id, title, image } = item;
        return (
          <div key={id} className="news-wrapper">
            <NewsBlock title={title} image={image} />;
          </div>
        );
      })}
    </section>
  );
};
export default News;
