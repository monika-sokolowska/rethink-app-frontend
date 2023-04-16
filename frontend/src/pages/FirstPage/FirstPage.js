import firstPage from "../../assets/images/firstPage.svg";
import Header from "../Header/Header";
import "./FirstPage.css";

const FirstPage = () => {
  return (
    <div>
      <Header />
      <div className="empty-page">
        <div className="info">
          <h1>Track your carbon footprint</h1>
          <h4>
            We all need to reduce our energy consumption if we want to protect
            our planet, but the concept of "energy saving" is rather abstract.
            Knowing your exact carbon footprint and then tracking how much
            energy you have saved can give you a better idea of your
            contribution to a greener environment.
          </h4>
          <div className="buttons">
            <button className="log-in">Log in</button>
            <button className="sign-up">Sign up</button>
          </div>
        </div>
        <div className="empty">
          <img className="first-page" src={firstPage} alt="firstPage" />
        </div>
      </div>
    </div>
  );
};

export default FirstPage;
