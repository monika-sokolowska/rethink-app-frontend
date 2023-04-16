import { Link } from "react-router-dom";
import Logo from "../Logo/Logo";
import "./Dashboard.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <Logo />
      <div className="links">
        <Link to="/" className="log-out">
          Log out
        </Link>
      </div>
    </nav>
  );
};
export default Navbar;
