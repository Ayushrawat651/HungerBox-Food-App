document.addEventListener('DOMContentLoaded', () => {

  console.log("Page Loaded and JavaScript Initialized");


  // Show Add Menu Item Form
  window.showAddMenuItemForm = function () {

    document.getElementById('add-item-form').style.display = 'flex';

  };

  // Close Add Menu Item Form
  window.closeAddMenuItemForm = function () {

    document.getElementById('add-item-form').style.display = 'none';

  };


  // Show Remove Menu Item Form
  window.showRemoveMenuItemForm = function () {

    document.getElementById('remove-item-form').style.display = 'flex';

  };



  // Close Remove Menu Item Form

  window.closeRemoveMenuItemForm = function () {

    document.getElementById('remove-item-form').style.display = 'none';

  };

});
