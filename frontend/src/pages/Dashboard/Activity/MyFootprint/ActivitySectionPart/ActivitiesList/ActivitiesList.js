import React, { useState } from "react";
import data from "./data";
import "./ActivitiesList.css";
import ActivitiesListItem from "./ActivitiesListItem/ActivitiesListItem";

const ActivitiesList = () => {
  const [activities, setActivities] = useState(data);

  return (
    <div className="activities-list">
      {activities.map((item) => {
        const { id, name, footprint, info } = item;
        return (
          <div key={id} className="activities">
            <ActivitiesListItem name={name} footprint={footprint} info={info} />
          </div>
        );
      })}
    </div>
  );
};
export default ActivitiesList;
