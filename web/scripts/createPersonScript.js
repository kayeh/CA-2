var getAll = function () {

    $(document).ready(function () {
        $("#submitCreate").click(function () {
            //   var data = document.getElementById("firstName");
            var data = $("#firstName").val();
            console.log(data);

            var dataObj = {
                firstName: $("#firstName").val(),
                lastName: $("#lastName").val(),
                email: $("#email").val(),
                addressStreet: $("#street").val(),
                addressAddInfo: $("#addressAddInfo").val(),
                phoneNo: $("#phoneNumber").val(),
                phoneDesc: $("#phoneDes").val(),
                city: $("#city").val(),
                zipCode: $("#zipCode").val(),
                hobbyName: $("#hobbiesName").val(),
                hobbyDesc: $("#hobbiesDes").val()

            };
            console.log(dataObj);
            
            for (var i in dataObj) {
                console.log(i + ", " + dataObj[i]);
            }

            $.ajax({
                url: "api/person",
                type: "POST",
                data: JSON.stringify(dataObj),
                dataType: "json",
                contentType: "application/json; charset=utf-8"
            }).done(function (doneData) {
                alert("success");
            }).fail(function (error) {
                alert("failed");
            });

        });

    });
};








getAll();


//        url: getUrl,
//                type: "POST",
//                JSON.stringify(data),
//                dataType: "json",
//                contentType: "application/json; charset=utf-8"



//            for (var i = 0; i < 10; i++) {
//                if (i === 10 || i === 0) {
//                    person = person + document.getElementsByTagName("input")[i].value;
//                } else {
//                    person = person + "," + document.getElementsByTagName("input")[i].value;
//                }
//            }
//            var
//            console.log(person);

//        $.post(
//                "https://localhost:8443/CA2_Eske_Joni/api/person/" + person,
//                function (data) {
//                alert("Response: " + data);
//                }
//        );
//});
