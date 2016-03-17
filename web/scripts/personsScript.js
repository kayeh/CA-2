var getAll = function () {
//get all persons in database
    $(document).ready(function () {
        $("#getPersons").click(function () {
            $.ajax({
                url: "http://localhost:8080/CA2_Eske_Joni/api/person/complete",
                type: "GET",
                dataType: "JSON",
                error: function (errorThrown) {

                    console.log(errorThrown);
                }
            }).then(function (data) {
                //alert("hej fra then");
                console.log(data);
                $('#thead').html("");
                $('#tbody').html("");
                var row;
                row = "<tr> <td><h1>Firstname</h1></td> <td><h1>Lastname</h1></td> <td><h1>Street</h1></td> <td><h1>Phones</h1></td> <td><h1>Hobbies</h1></td></tr>";
                $('#thead').append(row);
                for (var i = 0; i < data.length; i++) {
                    row = "<tr> <td>" + data[i].firstName + "</td>" + "<td>" + data[i].lastName +
                            "</td>" + "<td>" + data[i].street + "</td>" + "<td>" + data[i].phones + "</td>" + "<td>" + data[i].hobbies + "</td>" + "</tr>";
                    $('#tbody').append(row);
                }

            });
        });

    });
//clear table with list
    $(document).ready(function () {
        $("#clear").click(function () {
            $('#thead').html("");
            $('#tbody').html("");
        });
    });
//clear selection
    $(document).ready(function () {
        $("#clearSelection").click(function () {
            $('.radio-button').prop('checked', false);
        });

    });
//find persons selected by hobbys
    $(document).ready(function () {
        $("#getPersonByHobby").click(function () {
            $.ajax({
                url: "http://localhost:8080/CA2_Eske_Joni/api/person/complete",
                type: "GET",
                dataType: "JSON",
                error: function (errorThrown) {

                    console.log(errorThrown);
                }
            }).then(function (data) {
                //alert("hej fra then");
                console.log(data);
                $('#thead').html("");
                $('#tbody').html("");
                var row;
                var chosenHobby;

//                if (document.getElementByName('hobby').checked) {
//                    chosenHobby = document.getElementByName('hobby').value;
//                    console.log("hobby "+ chosenHobby)
//                }
                chosenHobby = document.querySelector('input[name="hobby"]:checked').value;

                row = "<tr> <td><h1>Firstname</h1></td> <td><h1>Lastname</h1></td> <td><h1>Street</h1></td> <td><h1>Phones</h1></td> <td><h1>Hobbies</h1></td></tr>";
                $('#thead').append(row);
                for (var i = 0; i < data.length; i++) {
                    console.log(data[i].hobbies[i])
                    for (var j = 0; j < data[i].hobbies.length; j++) {
                        if (data[i].hobbies[j] === chosenHobby) {
                            console.log("inside loop");

                            row = "<tr> <td>" + data[i].firstName + "</td>" + "<td>" + data[i].lastName +
                                    "</td>" + "<td>" + data[i].street + "</td>" + "<td>" + data[i].phones + "</td>" + "<td>" + data[i].hobbies + "</td>" + "</tr>";
                            $('#tbody').append(row);
                        }
                    }
                }


            });
        });

    });
//find amount of selected hobbys
    $(document).ready(function () {
        $("#getHowManyByHobby").click(function () {
            $.ajax({
                url: "http://localhost:8080/CA2_Eske_Joni/api/person/complete",
                type: "GET",
                dataType: "JSON",
                error: function (errorThrown) {

                    console.log(errorThrown);
                }
            }).then(function (data) {
                //alert("hej fra then");
                console.log(data);
                $('#thead').html("");
                $('#tbody').html("");
                var row;
                var chosenHobby;
                var number = 0;

//                if (document.getElementByName('hobby').checked) {
//                    chosenHobby = document.getElementByName('hobby').value;
//                    console.log("hobby "+ chosenHobby)
//                }
                chosenHobby = document.querySelector('input[name="hobby"]:checked').value;

                row = "<tr> " + "<td>" + chosenHobby + "</td>" + "</tr>";
                $('#thead').append(row);
                for (var i = 0; i < data.length; i++) {
                    console.log(data[i].hobbies[i])
                    for (var j = 0; j < data[i].hobbies.length; j++) {
                        if (data[i].hobbies[j] === chosenHobby) {

                            number++;

                        }

                    }

                }
                row = "<tr> <td>" + number + "</td>" + "</tr>";
                $('#tbody').append(row);


            });
        });

    });



};

getAll();





