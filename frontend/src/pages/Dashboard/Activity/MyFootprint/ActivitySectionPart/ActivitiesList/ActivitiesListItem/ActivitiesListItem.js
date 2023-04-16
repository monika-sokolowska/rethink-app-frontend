import "./ActivitiesListItem.css";
import { AiOutlineEdit } from "react-icons/ai";

const ActivitiesListItem = ({ name, footprint, info }) => {
  return (
    <div className="activities-list-item">
      <h3>{name}</h3>
      {info && <h3>{info}</h3>}
      <div className="activities-list-item-right-side">
        <h1>{footprint} kg CO2</h1>
        <AiOutlineEdit
          size={25}
          style={{ color: "#fff", marginRight: "2rem", height: "80%" }}
        />
      </div>
    </div>
  );
};
export default ActivitiesListItem;
