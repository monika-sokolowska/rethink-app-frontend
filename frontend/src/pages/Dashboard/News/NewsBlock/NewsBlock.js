import "./NewsBlock.css";

const NewsBlock = ({ title, image, text }) => {
  return (
    <div className="news-block">
      <div className="image-container">
        <img src={image} />
      </div>
      <div className="text-container">
        <h1>{title}</h1>
        <h3>{text}</h3>
      </div>
    </div>
  );
};
export default NewsBlock;
