import firstPage from "../../assets/images/firstPage.svg";
import Header from "../Header/Header";
import "./LoginPage.css";
import { Link } from "react-router-dom";

const LoginPage = () => {
  return (
    <div className="login-page-container">
      <Header />

      <div className="login-page">
        <div className="empty">
          <img className="first-page" src={firstPage} alt="firstPage" />
        </div>

        <div className="info">
          <form className="login-form">
            <div className="input">
              <label htmlFor="email">Email</label>
              <input type="text" id="email" />
            </div>
            <div className="input">
              <label htmlFor="email">Password</label>
              <input type="text" id="password" />
            </div>
            <button className="log-in-btn">Log in</button>
            <Link to="/register" className="register-link">
              Create an account
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
