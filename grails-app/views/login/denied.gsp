<head>
<meta name='layout' content='main' />
<title><g:message code="springSecurity.denied.title" /></title>
</head>

<body>

<r:script>


    // Login form - Done - returns json data.
    //$('form#loginForm').submit(function(event){
    $('form#loginForm').on("submit",(function(event){

        event.preventDefault();

        var e=$('#e').serialize(), p=$('#p').serialize();
        console.log(e + " " + p);
        //var http = new XMLHttpRequest();


        var url = "https://cloud.columbiaco.edu/integrations/Authenticate.aspx";
        var params = e + "&" + p;
        console.log(params);
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: params,
            context: document.body,
            processData: true,
            //crossDomain:true,
        }).done(function(data) {

                    var items = [];

                    $.each(data, function(key, val) {

                        alert ("This is Key" +  key + ":" + val);
                        console.log(key + " : " + val);

                        if (val.length == 7){
                            document.cookie=key + ":" + val;
                            $.cookie('studentid', val, {expires: 1, path: '/', domain: 'https://cloud.columbiaco.edu/integrations/'});
                            console.log("cookie: " + $.cookie(val));
                            localStorage.setItem(key, val);
                            console.log("session: " + sessionStorage.studentid);
                            alert($.cookie('studentid'));
                            var pushNotification = window.plugins.pushNotification;
                            pushNotification.setTags({"Estudiantes":val},
                                    function(status) {

                                        console.warn('setTags success');
                                    },
                                    function(status){
                                        console.warn('setTags Failed');
                                    }
                            );

                            $.mobile.navigate( "#ServicesLanding", {
                                info: "info about the #bar hash"

                            });

                            // Replace #bar with #baz
                            //$.mobile.navigate( "#servicesLanding" );

                            // Log the results of the navigate event
                            $( window ).on( "navigate", function( event, data ){
                                console.log( data.state.info );
                                console.log( data.state.direction );
                                console.log( data.state.url );
                                console.log( data.state.hash );
                            });
                        }else{
                            event.preventDefault();
                            $.mobile.navigate( "#services" );
                            $('div.login-response').html(function(){
                                var text = '<p>Favor Intenta de nuevo</p>';
                                return text;
                            });

                        }
                    });
                });
    }));
</r:script>
<div class='body'>
	<div class='errors'><g:message code="springSecurity.denied.message" />




    </div>
</div>
</body>
