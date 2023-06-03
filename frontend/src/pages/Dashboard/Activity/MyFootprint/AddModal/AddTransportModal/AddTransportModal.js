import Modal from "react-overlays/Modal";
import "../AddModal.css";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { useSelector } from "react-redux";
import { addTransportFootprint } from "../../../../../../reducers/dailyFootprintSlice";

const initialState = {
  name: "",
  kilometers: 0,
  footprint: 0,
};

const AddTransportModal = ({ isOpen, handleClose }) => {
  const [values, setValues] = useState(initialState);
  const { user } = useSelector((store) => store.user);
  const dispatch = useDispatch();
  const renderBackdrop = (props) => <div className="backdrop" {...props} />;
  const minFootprint = 0;
  const maxFootprint = 5000;

  const minKilometers = 0;
  const maxKilometers = 10000;

  const onSubmit = (e) => {
    e.preventDefault();
    const { name, kilometers, footprint } = values;
    console.log({
      name: name,
      kilometers: kilometers,
      footprint: footprint,
    });

    if (!name || !kilometers || !footprint) {
      toast.error("Please fill out all fields");
      return;
    }

    const userId = user.id;
    const addedFootprint = {
      name: name,
      kilometers: kilometers,
      footprint: footprint,
    };
    dispatch(
      addTransportFootprint({ userId: userId, addedFootprint: addedFootprint })
    );
    handleClose();
    setValues(initialState);
  };

  const onClose = () => {
    handleClose();
    setValues(initialState);
  };

  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;

    setValues({ ...values, [name]: value });
  };

  const handleNumberChange = (e) => {
    e.stopPropagation();

    const name = e.target.name;
    let value = e.target.value;

    if (name === "footprint") {
      value = Math.max(
        maxFootprint,
        Math.min(minFootprint, Number(e.target.value))
      );
    } else if (name === "kilometers") {
      value = Math.max(
        minKilometers,
        Math.min(maxKilometers, Number(e.target.value))
      );
    }

    setValues({ ...values, [name]: value });
  };

  return (
    <Modal
      className="modal"
      show={isOpen}
      onHide={handleClose}
      renderBackdrop={renderBackdrop}>
      <div className="modal">
        <div className="modal-header">
          <div className="modal-title">Add transport footprint</div>
          <div>
            <span className="close-button" onClick={handleClose}>
              x
            </span>
          </div>
        </div>
        <form className="footprint-form" onSubmit={onSubmit}>
          <div className="modal-desc">
            <div className="footprint-input">
              <label>Transport name</label>
              <input
                type="text"
                id="name"
                onChange={handleChange}
                name="name"
                value={values.name}
              />
            </div>
            <div className="footprint-input">
              <label>Kilometers</label>
              <input
                type="number"
                id="kilometers"
                onChange={handleNumberChange}
                name="kilometers"
                value={values.kilometers}
              />
            </div>
            <div className="footprint-input">
              <label>Footprint</label>
              <input
                type="number"
                id="footprint"
                onChange={handleNumberChange}
                name="footprint"
                value={values.footprint}
              />
            </div>
          </div>
          <div className="modal-footer">
            <button className="secondary-button" onClick={onClose}>
              Close
            </button>
            <input
              type="submit"
              value="Save Changes"
              className="primary-button"></input>
          </div>
        </form>
      </div>
    </Modal>
  );
};
export default AddTransportModal;
