import ActivitiesList from "./ActivitiesList/ActivitiesList";
import "./ActivitySectionPart.css";

const ActivitySectionPart = ({ label }) => {
  return (
    <div className="activity-section-part">
      <div className="activity-section-part-header">
        <div className="activity-section-part-label">{label}</div>
        <button>Add</button>
      </div>
      <ActivitiesList />
    </div>
  );
};
export default ActivitySectionPart;
