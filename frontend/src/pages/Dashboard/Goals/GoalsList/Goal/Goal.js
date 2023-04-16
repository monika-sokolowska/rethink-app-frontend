import "./Goal.css";
import { AiOutlineEdit } from "react-icons/ai";
import Checkbox from "@mui/material/Checkbox";
import CircleChecked from "@mui/icons-material/CheckCircleOutline";
import CircleUnchecked from "@mui/icons-material/RadioButtonUnchecked";

const Goal = ({ name }) => {
  return (
    <div className="goal">
      <Checkbox
        icon={
          <CircleUnchecked
            style={{ color: "#fff", marginLeft: "1rem", height: "80%" }}
          />
        }
        checkedIcon={
          <CircleChecked
            style={{ color: "#fff", marginLeft: "1rem", height: "80%" }}
          />
        }
        size={"small"}
      />
      <h3>{name}</h3>
      <AiOutlineEdit
        size={25}
        style={{ color: "#fff", marginRight: "2rem", height: "80%" }}
      />
    </div>
  );
};
export default Goal;
