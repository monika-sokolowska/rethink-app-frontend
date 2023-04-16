import React, { useState } from "react";
import data from "./data";
import "./GoalsList.css";
import Goal from "./Goal/Goal";

const GoalsList = () => {
  const [goals, setGoals] = useState(data);

  return (
    <div className="goals-list">
      {goals.map((item) => {
        const { id, name } = item;
        return (
          <article key={id} className="goals">
            <Goal name={name} />;
          </article>
        );
      })}
    </div>
  );
};
export default GoalsList;
