import React, { useState } from "react";
import "./GoalsList.css";
import Goal from "./Goal/Goal";
import { useEffect } from "react";
import { useSelector } from "react-redux";

const GoalsList = () => {
  const { goals } = useSelector((store) => store.goals);

  return (
    <div className="goals-list">
      {goals &&
        goals.map((item) => {
          const { id, description } = item;
          return (
            <article key={id} className="goals-article">
              <Goal name={description} />
            </article>
          );
        })}
    </div>
  );
};
export default GoalsList;
