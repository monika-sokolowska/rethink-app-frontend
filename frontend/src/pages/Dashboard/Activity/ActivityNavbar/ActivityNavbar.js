import { Link } from "react-router-dom";
import "./ActivityNavbar.css";

const ActivityNavbar = () => {
  return (
    <nav className="activity-navbar">
      <Link to="/home/activity" className="link">
        My carbon footprint
      </Link>
      <Link to="/home/activity/household" className="link">
        Household carbon footprint
      </Link>
    </nav>
  );
};
export default ActivityNavbar;
