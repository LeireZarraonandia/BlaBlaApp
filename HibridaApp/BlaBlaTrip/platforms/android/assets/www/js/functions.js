/***************** TRADUCTOR ****************************************/

function externalLinks(){
	$("#popupTraductor").attr("src",appConstants.externalLink);
}



/***************** VALORACION ****************************************/

function valoraci(){
	$("#inicio").hide();
	$("#footerVal").hide();
	$("#valoracion").show();
	$("#footerVal").show();
}



/***************** VOLVER ****************************************/

function irPais(p){
	pais=p;
	var imagen="url(img/"+pais+".png)";
		
	$("#titulo_pais").text(pais);
	$("#pais").css
	({
		"background-image": imagen,
		"height": "100%",
		"width": "100%",
		"position": "fixed",
		"top": "0",
		"left": "0",
		"background-size": "100% 100%"
	})
		
	$("#inicio").hide();
	$("#expresiones_pais").hide();
	$("#pais").show();	
	$("body").enhanceWithin();
}
	
function volver_pais(){
	$("#pais").show();
	$("#expresiones_pais").hide();
	$("#evaluacionTest").hide();	
}	
	
function volver_inicio(){
	$("#inicio").show();
	$("#pais").hide();
	$("#valoracion").hide();
}
		
function elegir_expresiones (){
	$("#titulo_expresiones").text(pais);
		
	$("#pais").hide();	
	$("#Tablas").hide();	
	$("#expresiones_pais").show();
}

function atras_1(i){
	$("#page-"+i).hide();
	$("#pais").show();
	
	for(var j=i;j<testInglaterra.total;j++)
    {
		$("#page-"+j).remove();
	}
	
	primeraVezTest=0;
	results.answered=0;
	results.corrects=0;
}



/*****************************	VALORACION   ************************************************/

function mail(){
	var mailto = 'nturumbay001@ikasle.ehu.eus';
	var subject = 'Valoración BlaBlaTrip';
	var body1 = $("#textarea_2").val();
	var bien = 'false';
	
	if(body1.toLowerCase()=="alemania" || body1.toLowerCase()=="francia" || body1.toLowerCase()=="italia" || body1.toLowerCase()=="portugal" || body1.toLowerCase()=="inglaterra" || body1.toLowerCase()=="")
	{
		var bien = 'true';
	}
	else
	{
		var bien = 'false';
	}
	
	if(bien == "true" && (body1.toLowerCase()=="alemania" || body1.toLowerCase()=="francia" || body1.toLowerCase()=="italia" || body1.toLowerCase()=="portugal" || body1.toLowerCase()=="inglaterra"))
	{
		var body2 = $("#textarea_4").val();
		var url = 'mailto:'+mailto+'?subject='+subject+'&body='+body1+' - '+body2;
		document.getElementById('bt_enviarMail').href = url
	}
	
	if(bien == "true" && body1=="")
	{
		var body2 = $("#textarea_4").val();
		var url = 'mailto:'+mailto+'?subject='+subject+'&body=BlaBlaTrip - '+body2;
		document.getElementById('bt_enviarMail').href = url
	}
	
	if(bien == "false")
	{
		alert("Nombre del país INCORRECTO\nSugerencias: Alemania, Francia, Inglaterra, Italia, Portugal\nVuelva a intentarlo");
		document.getElementById('bt_enviarMail').href = '#'
	}
}



/****************************************************** TEST ****************************************************************************/
	
function test(){
    alert("Test de "+pais+". A continuación tendrás que responder 10 preguntas");
	var pageDiv;
	
	for(var i=0; i<testInglaterra.total;i++)
	{
		primeraVezTest=1;
		pageDiv=pageTest.create(i);
		$("body").append(pageDiv);
		pageTest.load(i);
	}
	$("body").enhanceWithin();//////////////////////
	$("#pais").hide();	
	$("#page-0").show();
}
	
function check(i){
	results.answered++;
	
	var answer=$("input[name='radio-choice-"+i+"']:checked").val();
	
    switch(pais)
    {
        case 'Inglaterra':
        {
            if(answer==testInglaterra.test[i].correct) {
                alert("CORRECTO");
                results.corrects++;
            }
            else
                alert("INCORRECTO");
            
            $(".res-1").text(""+results.corrects+"/"+results.answered);
            $(".res-2").text(""+(results.corrects*100/results.answered).toFixed(2)+"%");
            $("label[id|='label-radio-choice-"+i+"']").each(
                function(index)
                {
                    if(index!=testInglaterra.test[i].correct)
                    {
                        $(this).css("color","red");
                    }
                    else
                    {
                        $(this).css({"color":"white","background-color":"green","font-size":"24px"});
                    }
                }
            );
            break;
        }
        case 'Francia':
        {
            if(answer==testFrancia.test[i].correct) {
                alert("CORRECTO");
                results.corrects++;
            }
            else
                alert("INCORRECTO");
            
            $(".res-1").text(""+results.corrects+"/"+results.answered);
            $(".res-2").text(""+(results.corrects*100/results.answered).toFixed(2)+"%");
            $("label[id|='label-radio-choice-"+i+"']").each(
                function(index)
                {
                    if(index!=testFrancia.test[i].correct)
                    {
                        $(this).css("color","red");
                    }
                    else
                    {
                        $(this).css({"color":"white","background-color":"green","font-size":"24px"});
                    }
                }
            );
            break;
        }
        case 'Alemania':
        {
            if(answer==testAlemania.test[i].correct) {
                alert("CORRECTO");
                results.corrects++;
            }
            else
                alert("INCORRECTO");
            
            $(".res-1").text(""+results.corrects+"/"+results.answered);
            $(".res-2").text(""+(results.corrects*100/results.answered).toFixed(2)+"%");
            $("label[id|='label-radio-choice-"+i+"']").each(
                function(index)
                {
                    if(index!=testAlemania.test[i].correct)
                    {
                        $(this).css("color","red");
                    }
                    else
                    {
                        $(this).css({"color":"white","background-color":"green","font-size":"24px"});
                    }
                }
            );
            break;
        }
        case 'Italia':
        {
            if(answer==testItalia.test[i].correct) {
                alert("CORRECTO");
                results.corrects++;
            }
            else
                alert("INCORRECTO");
            
            $(".res-1").text(""+results.corrects+"/"+results.answered);
            $(".res-2").text(""+(results.corrects*100/results.answered).toFixed(2)+"%");
            $("label[id|='label-radio-choice-"+i+"']").each(
                function(index)
                {
                    if(index!=testItalia.test[i].correct)
                    {
                        $(this).css("color","red");
                    }
                    else
                    {
                        $(this).css({"color":"white","background-color":"green","font-size":"24px"});
                    }
                }
            );
            break;
        }
        case 'Portugal':
        {
            if(answer==testPortugal.test[i].correct) {
                alert("CORRECTO");
                results.corrects++;
            }
            else
                alert("INCORRECTO");
            
            $(".res-1").text(""+results.corrects+"/"+results.answered);
            $(".res-2").text(""+(results.corrects*100/results.answered).toFixed(2)+"%");
            $("label[id|='label-radio-choice-"+i+"']").each(
                function(index)
                {
                    if(index!=testPortugal.test[i].correct)
                    {
                        $(this).css("color","red");
                    }
                    else
                    {
                        $(this).css({"color":"white","background-color":"green","font-size":"24px"});
                    }
                }
            );
            break;
        }
    }
    
	$("#button-"+i+"-1").attr("onclick","");
}

function siguientePag(i){
	var k=i+1;
	
	//if (primeraVezTest==1){
		$("#page-"+i).remove();
	
	
	$("#page-"+i).hide();

	if(i==(testInglaterra.total-1)){
		alert('Fin del test. Resultado: '+(results.corrects*100/results.answered).toFixed(2)+' %');
		$("#page-"+i).hide();
		$("#pais").show();
		results.answered=0;
		results.corrects=0;
	}
	$("#page-"+i).hide();
}



/******************************************** EXPRESIONES **************************************************************************************/

function expresiones(id){
	nApartado=id;
	var pageDiv;
	var db = 1;
	if(primeraVez==1)
		$("#Tablas").remove();

	pageDiv=page.create(db);
	$("body").append(pageDiv);
	page.load();
	
	$("#tabla").css
	({
		"height": "100%",
		"width": "100%",
		"margin": "0px",
		"padding":"0px"
	})
	
	$("#expresiones_pais").hide();
	$("#Tablas").show();
	
	primeraVez=1;
	$("body").enhanceWithin();
}



/************************** BASE DE DATOS **********************/

function expresDB(){
	var datosCastellano = [];
	var datosIdioma = [];
	var datosAudio = [];
	
	$.getJSON("http://51.254.127.111/BlaBlaTrip/conexion.php?pais="+pais, function(data)
			{

				for(var i=0; i<12; i++)
				{
					datosCastellano[i] = data[i].castellano;
					datosIdioma[i] = data[i].idioma;
					datosAudio[i] = data[i].audio;
				}
				
				var pageDiv;
				var db = 1;
				if(primeraVez==1)
					$("#Tablas").remove();

				pageDiv=pageDB.create(datosCastellano,datosIdioma,datosAudio);
				$("body").append(pageDiv);
				pageDB.load(datosCastellano,datosIdioma,datosAudio);
				
				$("#tabla").css
				({
					"height": "100%",
					"width": "100%",
					"margin": "0px",
					"padding":"0px"
				})
				
				$("#expresiones_pais").hide();
				$("#Tablas").show();
				
				primeraVez=1;
				$("body").enhanceWithin();
		})
		.fail(function(){
			alert("error conectando con el servidor");
	});
}