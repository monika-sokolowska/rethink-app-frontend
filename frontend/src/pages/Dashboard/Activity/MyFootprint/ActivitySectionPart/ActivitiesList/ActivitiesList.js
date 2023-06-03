import React, { useState } from "react";
import "./ActivitiesList.css";
import ActivitiesListItem from "./ActivitiesListItem/ActivitiesListItem";

const ActivitiesList = ({ data }) => {
  const displayActivitiesList = (item) => {
    if (item.kilometers) {
      return (
        <ActivitiesListItem
          name={item.name}
          footprint={item.footprint}
          info={`${item.kilometers} km`}
        />
      );
    }
    if (item.meal) {
      return (
        <ActivitiesListItem
          name={item.name}
          footprint={item.footprint}
          info={`${item.meal}`}
        />
      );
    } else {
      return (
        <ActivitiesListItem
          name={item.name}
          footprint={item.footprint}
          info={""}
        />
      );
    }
  };

  return (
    <div className="activities-list">
      {data.map((item) => {
        const { id } = item;
        return (
          <div key={id} className="activities">
            {displayActivitiesList(item)}
          </div>
        );
      })}
    </div>
  );
};
export default ActivitiesList;
