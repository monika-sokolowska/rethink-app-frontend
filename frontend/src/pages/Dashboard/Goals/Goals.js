import "./Goals.css";
import MainGoal from "./MainGoal/MainGoal";
import GoalsList from "./GoalsList/GoalsList";

const Goals = () => {
  return (
    <section className="goals">
      <MainGoal />
      <div className="other">
        <div className="other-label">Other goals</div>
        <button>Add</button>
      </div>
      <GoalsList />
    </section>
  );
};
export default Goals;
