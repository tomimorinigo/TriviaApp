import React from "react";
import "../assets/styles/ResultModal.css";

function ResultModal({ visible, content, onClose }) {
  return (
    <>
      {visible && (
        <div className="modal">
          <div className="modal-content">
            {content}
            <button onClick={onClose}>Cerrar</button>
          </div>
        </div>
      )}
    </>
  );
}

export default ResultModal;
