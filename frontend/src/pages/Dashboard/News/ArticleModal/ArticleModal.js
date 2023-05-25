import "./ArticleModal.css";

const ArticleModal = ({ title, image, text }) => {
  return (
    <div className="article-modal">
      <div className="image-container">
        <img src={image} />
      </div>
      <div className="text-container">
        <h1>{title}</h1>
      </div>
      <div className="text-container">
        <h1>{text}</h1>
      </div>
    </div>
  );
};
export default ArticleModal;
