import "./MainFootprint.css";
import { AiOutlineEdit } from "react-icons/ai";

const MainFootprint = () => {
  return (
    <div className="main-footprint">
      <h1>Household carbon footprint</h1>
      <div className="carbon-footprint-goal">
        <h3>kg CO2</h3>
        <AiOutlineEdit
          size={25}
          style={{ color: "#fff", marginRight: "2rem", height: "80%" }}
        />
      </div>
    </div>
  );
};
export default MainFootprint;
