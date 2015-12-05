var appConstants = {
	//Direccion IP del servidor
	serverURL: "http://51.254.127.111/BlaBlaTrip/", //   /subea.html para subir archivos
	externalLink:"http://www.wordreference.com/es/", //URL traductor
};

var pais=null;
var nApartado=null;
var primeraVez=0;
var db = 0;
var datosCastellano = [];
var datosIdioma = [];
var datosAudio = [];



/********************* TESTS *****************************************/

/*** INGLES ***/ 
var testInglaterra = {
		total: 10,
	    test: [
	           {
	           question: "¿Cómo le dices a una persona que no entiendes nada de lo que te dice?",
	           resp: [
	                  "Can you help me?",
	                  "I don´t know",
	                  "I don´t understand"
	                  ],
	                    correct:"2"
	           },
	           {
	           question:"¿Cómo dirías que quieres ir al hospital?",
	           resp: [
	                  "I need to go to the bank",
	                  "I need to go to the hospital", 
	                  "I need to go to the train"           
	                  ],
	                    correct: "1"
	           },
	           {
	           question:"¿Cómo preguntarías el precio de un producto?",
	           resp: [
	                  "How much is this?",
	                  "What time do you open/close",
	                  "What hour do you open/close?"
	                  ],
	                    correct: "0"
	           },
	           {
	           question:"¿Cómo preguntarías a qué hora abre o cierra un local?",
	           resp: [
	                  "How much is it?",
	                  "What time do you open/close?",
	                  "What hour do you open/close?"
	                  ],
	                    correct: "1"
	           },
	           {
	           question:"¿Cómo pedirías la comida en un restaurante?",
	           resp: [
	                  "Excuse me, we would like to order",
	                  "Excuse me, we would like to pay",
	                  "Excuse me, we would like to book a table"
	                  ],
	                  	correct: "0"
	           },
	           {
	           question:"¿Cómo dirías en un restaurante que lo que te han servido no es lo que has pedido?",
	           resp: [
	                  "We would like to pay",
	                  "I did not order this",
	                  "The food was delicious"
	                  ],
	                    correct: "1"
	           },
	           {
	           question:"¿Cómo dirías que tu llave de hotel no funciona?",
	           resp: [
	                  "My key does not work",
	                  "There is not water",
	                  "The air conditioning does not work"
	                  ],
	                    correct: "0"
	           },
	           {
	           question:"¿Cómo preguntarías cómo se llega a un sitio?",
	           resp: [
	                  "Can you show me where it is on the map?",
	                  "How do I get to...?",
	                  "Where I can find....?"
	                  ],
	                    correct: "1"
	           },
	           {
	           question:"¿Cómo expresarías que alguien te está molestando y quieres que te deje en paz?",
	           resp: [
	                  "Leave me",
	                  "Leave you alone",
	                  "Leave me alone "
	                  ],
	                    correct: "2"
	           },
	           {
	           question:"¿Cómo se dice buenos días?",
	           resp: [
	                  "Good morning",
	                  "Good afternoon",
	                  "Good night"
	                  ],
	                    correct: "0"
	           }
	    ]
	}

/*** FRANCES ***/
var testFrancia = {
		total: 10,
	    test: [
	           {
	           question:"¿Cómo preguntarías a alguien que edad tiene?",
			   resp: [
			          "Quel âge as-tu?",
			          "Quel est ton `poids?",
			          "Combien tu?"
			          ],
						correct: "0"
	           },
	           {
	           question:"¿Cómo preguntarías por el encargado de un local o tienda?",
	           resp: [
	                  "Serait îl posible manger quelque chose?",
	                  "On pourrait parlez en privé?",
	                  "Qui est le reponsable ici?"
	                  ],
						correct: "2"
				},
				{
				question:"¿Cómo le dirías a una persona que llame a una ambulancia?",
				resp: [
				       "pouvez vous appeler un taxi?",
				       "Appelez une ambulance",
				       "Vous pouvez appeler un médecin?"		
				       ],
						correct: "1"
				},
				{
				question:"¿Cómo de dirías a un médico 'me duele aquí?'",
				resp: [
						"Ça fait toujours mal",
						"Ça fait mal que pendant la nuit",
						"J’ai mal là"
						],
						 correct: "2"
				},
				{
				question:"¿Cómo preguntarías cuánto cuesta algo?",
				resp: [
				       "Combien ça coûte?",
				       "À ce moment-là se ferme?",
				       "Lorsque ce compteur?"
				       ],
						correct: "0"
				},
				{
				question:"¿Cómo preguntarías en un hotel si el desayuno está incluido?",
				resp: [
				       "Combien coûte une chambre?",
				       "Puis-je payer par carte ?",
				       "Le petit-déjeuner est inclus?"
				       ],
						correct: "2"
				},
				{
				question:"¿Cómo dirías el número dos en Francés?",
				resp: [
				       "Trois",
				       "Cinq",
				       "Deux"	
				       ],
						correct: "2"
				},
				{
				question:"¿Cómo dirías en un restaurante que lo que te han traído no es lo que habías pedido?",
				resp: [
				       "Ce n’est pas ce que j’ai demandé ",
				       "La nourriture est très riche",
				       "La nourriture est froide"
				       ],
				       	correct: "0"
				},
				{
				question:"¿Cómo comunicaría a alguien que se encuentra perdido?",
				resp: [
				       "Je suis fatigué",
				       "Je suis étourdie",
				       "Je suis perdu"
				       ],
				       	correct: "2"
				},
				{
				question:"¿Cómo preguntarías a alguien si quiere bailar?",
				resp: [
				       "Vous voulez danser?",
				       "Vous souhaitez boire?",
				       "Vous êtes froid?"
				       ],
				       	correct: "0"
				}
	    ]
	}

/*** ALEMAN ***/
var testAlemania = {
		total: 10,
	    test: [
	           {
	           question:"¿Qué respondes cuando alguien te sostiene la puerta en Alemania?",
			   resp: [
			          "Das verstehe ich nicht",
			          "Vielen Dank",
			          "Gern geschehen"
			          ],
			          	correct: "1"
				},
				{
				question:"¿Cómo preguntarías cuántos años tiene alguien en Alemania?",
				resp: [
				       "Woher kommst Du?",
				       "Wie heibt du?",
				       "Wie alt bist du?"
				       ],
						correct: "2"
				},
				{
				question:"¿Cómo te disculpas en alemán?",
				resp: [
				       "Entschuldigung",
				       "Gern geschehen",
				       "Es tut mir Leid"
				       ],
				       	correct: "2"
				},
				{
				question:"¿Qué dices si quieres que te devuelvan el dinero en Alemania?",
				resp: [
				       "Ich will mein Geld zurück",
				       "Ich möchte mich beschweren",
				       "Es tut mir Leid"
				       ],
						correct: "0"
				},
				{
				question:"¿Cómo expresas en alemán que necesitas ir al hospital?",
				resp: [
				       "Mir ist übel",
				       "Ich möchte mich beschweren",
				       "Ich muss ein Krankhaus"	
				       ],
						correct: "2"
				},
				{
				question:"¿Qué preguntas si quieres saber el precio de algo en Alemania?",
				resp: [
				       "Wo sind die Umkleidekabinen?",
				       "Wieviel kostet das?",
				       "Um wieviel Uhr öffnen?"
				       ],
						correct: "1"
				},
				{
				question:"¿Cómo pides la cuenta después de una comida en alemán?",
				resp: [
				       "Entschuldigung, wir würden gern bestellen, bitte",
				       "Kann ich die Speisekarte haben, bitten?",
				       "Wir möchten gern bezahlen, bitte"
				       ],
						correct: "2"
				},
				{
				question:"¿Cómo preguntas en alemán si existen habitaciones disponibles?",
				resp: [
						"Sind irgendwelche Zimmer frei?",
						"Ist Frühstück inklusive?",
						"Kann ich die Speisekarte haben, bitte?"	
						],
						 correct: "0"
				},
				{
				question:"¿Qué dirías en Alemania si el agua en tu habitación sale fría?",
				resp: [
						"Des Shlüssel funktioniert nicht",
						"Die Klimaanlage funktioniert nicht",
						"Es gibt kein heibes Wasser"
						],
						 correct: "2"
				},
				{
				question:"¿Cómo invitas a un café a un/una alemana?",
				resp: [
					   "Würdest Du mit mi reinen Kaffe trinken gehen?",
					   "Hast Du heute Abend etwas vor?",
					   "Möchtest Du bei mir einen Film shauen?"
					   ],
					   	correct: "0"
				}
			]
	}

/*** ITALIANO ***/
var testItalia = {
		total: 10,
	    test: [
	           {
	           question:".¿Cómo pedirías ayuda?",
	           resp: [
	                  "Non capisco",
	                  "Puòaiutarmi? ",
	                  "Come va?"	
	                  ],
						correct: "1"
				},
				{
				question:"¿De qué manera expresarías que has estado esperando por más de una hora?",
				resp: [
				       "Stiamoaspettando da più di un´ora",
				       "E-davveroinammissibile",
				       "Rivoglio in dietro i mieisoldi"
						],
						  correct: "0"
				},
				{
				question:"¿Cómo le dirías al médico dónde te duele?",
				resp: [
				       "Ho la febbre",
				       "Ho ilraffreddore",
				       "Mifa malequi"
				       ],
						correct: "2"
				},
				{
				question:"¿De que manera expresarías que vas a comprar algo?",
				resp: [
				       "Lo compro",
				       "Sto dando unócchiata",
				       "Quanto costa questo?"
				       ],
						correct: "0"
				},
				{
				question:"¿Cómo expresarías que quieres ver el menú?",
				resp: [
				       "Scusi, vorremmo ordinare",
				       "Il conto, per favore",
				       "Mi porta il menú"
				       ],
						correct: "2"
				},
				{
				question:"¿De qué forma preguntarías si hay habitaciones libres?",
				resp: [
				       "Quanto costa una camera per…. Persone?",
				       "La colazione è inclusa?",
				       "Avetecamera libre?"
				       ],
						correct: "2"
				},
				{
				question:"¿Cómo dirías que estás perdido?",
				resp: [
				       "Mi sonoperso",
				       "Come si arriba…",
				       "Gira a sinistra"
				       ],
						correct: "0"
				},
				{
				question:"¿Cómo le dirías a alguien que quieres invitarle a una copa?",
				resp: [
				       "Cosa fai de bello nella vita?",
				       "Possoofffrirtiqualcosa da bere?",
				       "Ti Va di ballare?"
				       ],
				       	correct: "1"
				},
				{
				question:"¿Cómo pedirías la cuenta?",
				resp: [
				       "Ilcibo era delizioso",
				       "Scusi, vorremmo ordinare",
				       "Il conto, per favore"
				       ],
				       	correct: "2"
				},
				{
				question:"¿Cómo le comunicarías al médico que tienes tos?",
				resp: [
				       "Ho la tosse",
				       "Ho la febbre",
				       "Ho ilraffreddore"
				       ],
						correct: "0"
				}
	    ]
	}

/*** PORTUGUES ***/
var testPortugal = {
		total: 10,
	    test: [
	          {
	          question:"¿Cómo pedirías ayuda?",
	          resp: [
	                 "Come voê está?",
	                 "Você pode me ajudar,, por favor?",
	                 "Como você se chama?"
	                 ],
	                  correct: "1"
				},
				{
				question:"Si tu nombre es Pablo. ¿Cuál es la manera correcta de presentarte?",
				resp: [
				       "Meu nome é Pablo",
				       "Quanto custa um quarto para Pablo pessoa?",
				       "Eu sou do Pablo"
				       ],
						correct: "0"
				},
				{
				question:".¿Cómo preguntarías de qué trabaja alguien?",
				resp: [
				       "O que você faz na vida?",
				       "Deixe-me sozinho?",
				       "Como eu façco para chegar?"
				       ],
				       	correct: "0"
				},
				{
				question:"¿Cómo expresarías que quieres llegar a Lisboa?",
				resp: [
				       "Quanto custa um quarto para Lisboa pessoa?",
				       "Posso ver o cardápio, Lisboa?",
				       "Como eu façco para chegar a Lisboa?"
				       ],
						correct: "2"
				},
				{
				question:".¿Cómo dirías en un restaurante que lo que te han servido no es lo que has pedido?",
				resp: [
				       "Pode ficar com o troco",
				       "A comida estava deliciosa",
				       "Eu não pedi isso"
				       ],
						correct: "2"
				},
				{
				question:"Cuando alguien tiene que girar a la izquierda le guiaremos utilizando:",
				resp: [
				       "Vire á esquerda",
				       "Siga em frente",
				       "Vire á direita"
				       ],
						correct: "0"
				},
				{
				question:"¿Cómo dirías que vas a comprar algo?",
				resp: [
						"Estou apenas olhando",
						"Eu vou levar",
						"Eu gostaria devolver"
						],
						 correct: "1"
				},
				{
				question:"¿Cómo expresarías al médico que  tu enfermedad de estómago ha empeorado?",
				resp: [
						"Estou me sentindo pior",
						"Sinto-me um pouco melhor",
						"Estou como antes"
						],
						 correct: "0"
				},
				{
				question:"¿De que manera preguntarías el precio de algún objeto?",
				resp: [
				       "Você tm alguma coisa mais barata?",
				       "Quanto custa isso?",
				       "Você pode lme dar uma sacola, por favor?"
				       ],
						correct: "1"
				},
				{
				question:"¿Cómo le dIrías al médico que tienes fiebre?",
				resp: [
				       "Estou com febre",
				       "Estou resfriadoo",
				       "Estou como antes"
				       ],
						correct: "0"
				}
	    ]
	}

var results = {
		corrects: 0,
		answered: 0
	};

var pageTest = {
		create: function(i) {
			var contentDiv=null;
			var headerDiv=null;
			var footerDiv=null;
			
			var pageDiv=$('<div data-role="page" id="page-'+i+'"></div>');
			var headerDiv=
				'<div data-role="header" data-position="fixed" data-theme="b">'+
					'<h1 style="margin-left:0;margin-right:0;white-space: nowrap;overflow: visible;">Test</h1>'+
					'<a onclick="atras_1('+i+')" class="ui-btn ui-btn-inline ui-btn-right">Terminar</a>'+
				'</div>';
			
			if(i==0)
			{
				var contentDiv=
					'<div data-role="content">'+
						'</br></br>'+
						'<form id="form-'+i+'">'+
							'<fieldset data-role="controlgroup" data-iconpos="right">'+
								'<legend id="question-'+i+'"></legend>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'a" data-mini="true" value="0" type="radio"/>'+
								'<label for="radio-choice-'+i+'a" id="label-radio-choice-'+i+'-0"></label>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'b" data-mini="true" value="1" type="radio"/>'+
								'<label for="radio-choice-'+i+'b" id="label-radio-choice-'+i+'-1"></label>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'c" data-mini="true" value="2" type="radio"/>'+
								'<label for="radio-choice-'+i+'c" id="label-radio-choice-'+i+'-2"></label>'+
							'</fieldset>'+					
							'<div style="text-align:center;">'+
								'<a href="" id="button-'+i+'-1" class="ui-btn ui-btn-inline ui-corner-all" onclick="check('+i+')">COMPROBAR</a>'+
							'</div>'+
						'</form>'+
					'</div>'
			}
			else
			{
				var contentDiv=
					'<div data-role="content">'+
						'<form id="form-'+i+'">'+
							'<fieldset data-role="controlgroup" data-iconpos="right">'+
								'<legend id="question-'+i+'"></legend>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'a" data-mini="true" value="0" type="radio"/>'+
								'<label for="radio-choice-'+i+'a" id="label-radio-choice-'+i+'-0"></label>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'b" data-mini="true" value="1" type="radio"/>'+
								'<label for="radio-choice-'+i+'b" id="label-radio-choice-'+i+'-1"></label>'+
								'<input name="radio-choice-'+i+'" id="radio-choice-'+i+'c" data-mini="true" value="2" type="radio"/>'+
								'<label for="radio-choice-'+i+'c" id="label-radio-choice-'+i+'-2"></label>'+
							'</fieldset>'+					
							'<div style="text-align:center;">'+
								'<a href="" id="button-'+i+'-1" class="ui-btn ui-btn-inline ui-corner-all" onclick="check('+i+')">COMPROBAR</a>'+
							'</div>'+
						'</form>'+
					'</div>'
			}
				
			;
			
			
			var footerDiv=
				'<div data-role="footer" data-position="fixed" id="footerTest">'+
					'<div class="ui-grid-b" style="width:80%; text-align:center; font-weight:normal;">'+
						'<div class="ui-block-a">RESULTADO: </div>'+
						'<div class="ui-block-b res-1" id="res-'+i+'-1"></div>'+
						'<div class="ui-block-c res-2" id="res-'+i+'-2"></div>'+
					'</div>'+			
					'<h4>BlaBlaTrip</h4>'+
					/*'<a href="#" id="prev-'+i+'" class="ui-btn ui-mini ui-corner-all ui-icon-arrow-l ui-btn-icon-left" data-transition="turn">Anterior</a>'+*/
					'<a onclick="siguientePag('+i+')" id="next-'+i+'" class="ui-btn ui-mini ui-corner-all ui-icon-arrow-r ui-btn-icon-left">Siguiente</a>'+
				'</div>';
			
			
			pageDiv.append(headerDiv,contentDiv,footerDiv); //Añadir encabezado, contenido y pie al pageTest

			return pageDiv;
		},
		
		load: function(i)
		{
			var j=i+1;//para que las preguntas sean de 1 a 10 en vez de 0 a 9
			switch(pais)
			{
				case 'Inglaterra':
					$("#question-"+i).text("PREGUNTA "+j+": "+testInglaterra.test[i].question);
	    	
					$("label[id|='label-radio-choice-"+i+"']").each(
	     			function(index) {     				
	     				$(this).text(testInglaterra.test[i].resp[index]);     				
	     				}
					);
					break;
					
				case 'Francia':
					$("#question-"+i).text("PREGUNTA "+j+": "+testFrancia.test[i].question);
	    	
					$("label[id|='label-radio-choice-"+i+"']").each(
	     			function(index) {     				
	     				$(this).text(testFrancia.test[i].resp[index]);     				
	     				}
					);
					break;
				case 'Italia':
					$("#question-"+i).text("PREGUNTA "+j+": "+testItalia.test[i].question);
	    	
					$("label[id|='label-radio-choice-"+i+"']").each(
	     			function(index) {     				
	     				$(this).text(testItalia.test[i].resp[index]);     				
	     				}
					);
					break;
				case 'Alemania':
					$("#question-"+i).text("PREGUNTA "+j+": "+testAlemania.test[i].question);
	    	
					$("label[id|='label-radio-choice-"+i+"']").each(
	     			function(index) {     				
	     				$(this).text(testAlemania.test[i].resp[index]);     				
	     				}
					);
					break;
				case 'Portugal':
					$("#question-"+i).text("PREGUNTA "+j+": "+testPortugal.test[i].question);
	    	
					$("label[id|='label-radio-choice-"+i+"']").each(
	     			function(index) {     				
	     				$(this).text(testPortugal.test[i].resp[index]);     				
	     				}
					);
					break;
			}
	     	
	     	
	     	$("#prec-"+i).attr("href","#page-"+(i-1))//poner el href del botón prev a la pageTest anterior
	     	$("#next-"+i).attr("href","#page-"+(i+1))//poner el href del botón next a la pageTest siguiente
	 	}
}



/********************************************* EXPRESIONES *************************************************************************************/

var ingles=  {
		info:[
		      {
		apartado: "Básicas",
		nFilas: 23,
		lineas:
			[
				{castellano:"¿Podría ayudarme?",idioma:"Can you help me?",audio: appConstants.serverURL+"EN-Bas-01.wav"},
				{castellano:"No entiendo",idioma:"I don’t understand",audio:appConstants.serverURL+"EN-Bas-02.wav"},
				{castellano:"Hola",idioma:"Hello",audio:appConstants.serverURL+"EN-Bas-03.wav"},
				{castellano:"Buenos días",idioma:"Good morning",audio:appConstants.serverURL+"EN-Bas-04.wav"},
				{castellano:"Buenas tardes",idioma:"Good evening",audio:appConstants.serverURL+"EN-Bas-05.wav"},
				{castellano:"Buenas noches",idioma:"Good night",audio:appConstants.serverURL+"EN-Bas-06.wav"},
				{castellano:"¿Cómo estás?",idioma:"How are you?",audio:appConstants.serverURL+"EN-Bas-07.wav"},
				{castellano:"Bien, gracias",idioma:"Good, thank you",audio:appConstants.serverURL+"EN-Bas-08.wav"},
				{castellano:"¿Cómo te llamas?",idioma:"What’s your name? ",audio:appConstants.serverURL+"EN-Bas-09.wav"},
				{castellano:"Me llamo… ",idioma:"My name is…",audio:appConstants.serverURL+"EN-Bas-10.wav"},
				{castellano:"¿De qué país vienes? ",idioma:"Where are you from?",audio:appConstants.serverURL+"EN-Bas-11.wav"},
				{castellano:"Soy de…",idioma:"I am from…",audio:appConstants.serverURL+"EN-Bas-12.wav"},
				{castellano:"¿Cuántos años tienes?",idioma:"How old are you?",audio:appConstants.serverURL+"EN-Bas-13.wav"},
				{castellano:"Tengo … años",idioma:"I am … years old",audio:appConstants.serverURL+"EN-Bas-14.wav"},
				{castellano:"Sí",idioma:"Yes ",audio:appConstants.serverURL+"EN-Bas-15.wav"},
				{castellano:"No",idioma:"No",audio:appConstants.serverURL+"EN-Bas-16.wav"},
				{castellano:"Por favor",idioma:"Please",audio:appConstants.serverURL+"EN-Bas-17.wav"},
				{castellano:"Muchas  gracias",idioma:"Thank you very much",audio:appConstants.serverURL+"EN-Bas-18.wav"},
				{castellano:"De nada",idioma:"You are welcome",audio:appConstants.serverURL+"EN-Bas-19.wav"},
				{castellano:"Lo siento",idioma:"I am sorry",audio:appConstants.serverURL+"EN-Bas-20.wav"},
				{castellano:"Disculpe ",idioma:"Excuse me",audio:appConstants.serverURL+"EN-Bas-21.wav"},
				{castellano:"Fue un placer conocerte",idioma:"It was nice meeting you",audio:appConstants.serverURL+"EN-Bas-22.wav"},
				{castellano:"Adiós ",idioma:"Good bye",audio:appConstants.serverURL+"EN-Bas-23.wav"}
				
			 ]
		      },{
		apartado: "Salud",
		nFilas: 13,
		lineas:[
				{castellano:"Necesito ir al hospital",idioma:"I need to go to the hospital",audio:appConstants.serverURL+"EN-Sal-01.wav"},
				{castellano:"Me siento mal",idioma:"I feel sick",audio:appConstants.serverURL+"EN-Sal-02.wav"},
				{castellano:"Necesito ver a un doctor inmediatamente",idioma:"I need to see a doctor inmediately",audio:appConstants.serverURL+"EN-Sal-03.wav"},
				{castellano:"Ayuda",idioma:"Help ",audio:appConstants.serverURL+"EN-Sal-04.wav"},
				{castellano:"Llamen a una ambulancia",idioma:"Call an ambulance",audio:appConstants.serverURL+"EN-Sal-05.wav"},
				{castellano:"Me duele aquí",idioma:"It hurts here",audio:appConstants.serverURL+"EN-Sal-06.wav"},
				{castellano:"Tengo fiebre",idioma:"I have fever",audio:appConstants.serverURL+"EN-Sal-07.wav"},
				{castellano:"Tengo un resfriado",idioma:"I have a cold",audio:appConstants.serverURL+"EN-Sal-08.wav"},
				{castellano:"¿Cuántas veces al día debo tomar esto?",idioma:"How many times a day should I take this?",audio:appConstants.serverURL+"EN-Sal-09.wav"},
				{castellano:"Me siento un poco mejor",idioma:"I feel a bit better",audio:appConstants.serverURL+"EN-Sal-10.wav"},
				{castellano:"Ha empeorado",idioma:"It has gotten worse",audio:appConstants.serverURL+"EN-Sal-11.wav"},
				{castellano:"Está igual que antes",idioma:"It is the same as before",audio:appConstants.serverURL+"EN-Sal-12.wav"},
				{castellano:"Tengo tos",idioma:"I have a cough",audio:appConstants.serverURL+"EN-Sal-13.wav"}
											
				]
		      },{
		apartado: "Compras",
		nFilas: 8,
		lineas:[	
				{castellano:"¿Cuánto cuesta?",idioma:"How much is this?",audio:appConstants.serverURL+"EN-Com-01.wav"},
				{castellano:"¿Tiene algo que sea más barato?",idioma:"Do you have anything that is less expensive?",audio:appConstants.serverURL+"EN-Com-02.wav"},
				{castellano:"¿A qué hora abre/cierra?",idioma:"What time do you open/close?",audio:appConstants.serverURL+"EN-Com-03.wav"},
				{castellano:"Sólo estoy mirando",idioma:"I am just browsing",audio:appConstants.serverURL+"EN-Com-04.wav"},
				{castellano:"Lo compro",idioma:"I will buy",audio:appConstants.serverURL+"EN-Com-05.wav"},
				{castellano:"¿Me puede dar una bolsa, por favor?",idioma:"May I have a bag, please?",audio:appConstants.serverURL+"EN-Com-06.wav"},
				{castellano:"Me gustaría devolver esto",idioma:"I would like to return this",audio:appConstants.serverURL+"EN-Com-07.wav"},
				{castellano:"¿Dónde se encuentran los probadores?",idioma:"Where are the changing rooms?",audio:appConstants.serverURL+"EN-Com-08.wav"}
				]
		      },{	
		apartado: "Comer",
		nFilas: 7,
		lineas:[
				{castellano:"Me gustaría reservar una mesa para … personas a las …",idioma:"I would like to book a table for … at …",audio:appConstants.serverURL+"EN-SalirComer-01.wav"},
				{castellano:"¿Puedo ver el menú?",idioma:"May I see the menu?",audio:appConstants.serverURL+"EN-SalirComer-02.wav"},
				{castellano:"Disculpe, nos gustaría pedir",idioma:"Excuse me, we would like to order",audio:appConstants.serverURL+"EN-SalirComer-03.wav"},
				{castellano:"Nos gustaría pagar la cuenta",idioma:"We would like to pay",audio:appConstants.serverURL+"EN-SalirComer-04.wav"},
				{castellano:"Quédese con el cambio",idioma:"Keep the change",audio:appConstants.serverURL+"EN-SalirComer-05.wav"},
				{castellano:"La comida estuvo deliciosa",idioma:"The food was delicious",audio:appConstants.serverURL+"EN-SalirComer-06.wav"},
				{castellano:"Yo no pedí esto",idioma:"I did not order this",audio:appConstants.serverURL+"EN-SalirComer-07.wav"}
				
				]
		      },{
				
		apartado: "Hospedaje",
		nFilas: 8,
		lineas:[	
				{castellano:"¿Dónde puedo encontrar …?",idioma:"Where can I find …?",audio:appConstants.serverURL+"EN-Hosp-01.wav"},
				{castellano:"¿Tiene habitaciones disponibles?",idioma:"Do you have any rooms available?",audio:appConstants.serverURL+"EN-Hosp-02.wav"},
				{castellano:"¿Cuál es el precio de una habitación para … personas?",idioma:"How much is a room for … people?",audio:appConstants.serverURL+"EN-Hosp-03.wav"},
				{castellano:"Me gustaría reservar",idioma:"I would like to book",audio:appConstants.serverURL+"EN-Hosp-04.wav"},
				{castellano:"¿El desayuno está incluido?",idioma:"Is breakfast included?",audio:appConstants.serverURL+"EN-Hosp-05.wav"},
				{castellano:"No hay agua caliente",idioma:"There is not hot water",audio:appConstants.serverURL+"EN-Hosp-06.wav"},
				{castellano:"El aire acondicionado no funciona",idioma:"The air conditioning does not work",audio:appConstants.serverURL+"EN-Hosp-07.wav"},
				{castellano:"Mi llave no funciona",idioma:"My key does not work",audio:appConstants.serverURL+"EN-Hosp-08.wav"}
				
				]
		      },/*{
				
		apartado: "Números",
		nFilas: 12,
		lineas:[		
				{castellano:"Uno",idioma:"One",audio:appConstants.serverURL+"EN-Num-01.wav"},
				{castellano:"Dos",idioma:"Two	",audio:appConstants.serverURL+"EN-Num-02.wav"},
				{castellano:"Tres ",idioma:"Three",audio:appConstants.serverURL+"EN-Num-03.wav"},
				{castellano:"Cuatro",idioma:"Four",audio:appConstants.serverURL+"EN-Num-04.wav"},
				{castellano:"Cinco",idioma:"Five",audio:appConstants.serverURL+"EN-Num-05.wav"},
				{castellano:"Seis",idioma:"Six",audio:appConstants.serverURL+"EN-Num-06.wav"},
				{castellano:"Siete	",idioma:"Seven",audio:appConstants.serverURL+"EN-Num-07.wav"},
				{castellano:"Ocho ",idioma:"Eight",audio:appConstants.serverURL+"EN-Num-08.wav"},
				{castellano:"Nueve ",idioma:"Nine",audio:appConstants.serverURL+"EN-Num-09.wav"},
				{castellano:"Diez",idioma:"Ten",audio:appConstants.serverURL+"EN-Num-10.wav"},
				{castellano:"Cien ",idioma:"Hundred",audio:appConstants.serverURL+"EN-Num-11.wav"},
				{castellano:"Millón ",idioma:"Million",audio:appConstants.serverURL+"EN-Num-12.wav"}
								
				]
		      },*/{		
		apartado: "Viajar",
		nFilas: 11,
		lineas:[			
				{castellano:"Estoy perdido",idioma:"I am lost",audio:appConstants.serverURL+"EN-Via-01.wav"},
				{castellano:"¿Me puede mostrar su ubicación en el mapa?",idioma:"Can you show me where it is on the map?",audio:appConstants.serverURL+"EN-Via-02.wav"},
				{castellano:"¿Dónde puedo encontrar …?",idioma:"Where can I find …?",audio:appConstants.serverURL+"EN-Via-03.wav"},
				{castellano:"¿Cómo llego a …?",idioma:"How do I get to …?",audio:appConstants.serverURL+"EN-Via-04.wav"},
				{castellano:"Gire a la izquierda ",idioma:"Turn left",audio:appConstants.serverURL+"EN-Via-05.wav"},
				{castellano:"Gire a la derecha",idioma:"Turn right",audio:appConstants.serverURL+"EN-Via-06.wav"},
				{castellano:"Siga derecho",idioma:"Go straight ahead",audio:appConstants.serverURL+"EN-Via-07.wav"},
				{castellano:"Regrese",idioma:"Go back",audio:appConstants.serverURL+"EN-Via-08.wav"},
				{castellano:"¿Dónde puedo comprar un ticket para el autobús/tren?",idioma:"Where can I buy a bus/train ticket?",audio:appConstants.serverURL+"EN-Via-09.wav"},
				{castellano:"¿Está ocupado este asiento?",idioma:"Is this seat taken?",audio:appConstants.serverURL+"EN-Via-10.wav"},
				{castellano:"Ese es mi asiento",idioma:"This is my seat",audio:appConstants.serverURL+"EN-Via-11.wav"}
			]
		 },{	
		apartado: "Quejas",
		nFilas: 5,
		lineas:[
				{castellano:"Me gustaría realizar una queja",idioma:"I would like to make a complaint",audio:appConstants.serverURL+"EN-Que-01.wav"},
				{castellano:"¿Quién es el encargado?",idioma:"Who is in charge here?",audio:appConstants.serverURL+"EN-Que-02.wav"},
				{castellano:"Esto es totalmente inaceptable",idioma:"This is totally unaceptable",audio:appConstants.serverURL+"EN-Que-03.wav"},
				{castellano:"Quiero mi dinero de vuelta",idioma:"I want my money back",audio:appConstants.serverURL+"EN-Que-04.wav"},
				{castellano:"Hemos estado esperando por más de una hora",idioma:"We have been waiting for over an hour",audio:appConstants.serverURL+"EN-Que-05.wav"},					
			]
		 },{		
		apartado: "Coqueteo",
		nFilas: 15,
		lineas:[				
				{castellano:"¿Te puedo invitar a algo para beber?",idioma:"May I buy you something to drink?",audio:appConstants.serverURL+"EN-Coq-01.wav"},
				{castellano:"¿A qué te dedicas?",idioma:"What do you do for a living?",audio:appConstants.serverURL+"EN-Coq-02.wav"},
				{castellano:"¿Quieres bailar?",idioma:"Do you want to dance?",audio:appConstants.serverURL+"EN-Coq-03.wav"},
				{castellano:"¿Te gustaría salir un poco?",idioma:"Would yo like to get some fresh air?",audio:appConstants.serverURL+"EN-Coq-04.wav"},
				{castellano:"¿Vamos a mi casa o a la tuya?",idioma:"My place or yours?",audio:appConstants.serverURL+"EN-Coq-05.wav"},
				{castellano:"¿Te gustaría ver una película en mi casa?",idioma:"Would you like to watch a movie at my place?",audio:appConstants.serverURL+"EN-Coq-06.wav"},
				{castellano:"¿Tienes algún plan para esta noche?",idioma:"Do you have any plans for tonight?",audio:appConstants.serverURL+"EN-Coq-07.wav"},
				{castellano:"¿Te gustaría ir a tomar un café?",idioma:"Would you like to get a coffee?",audio:appConstants.serverURL+"EN-Coq-08.wav"},
				{castellano:"¿Te llevo/acompaño a tu casa?",idioma:"May I walk/drive you home?",audio:appConstants.serverURL+"EN-Coq-09.wav"},
				{castellano:"¡Me lo pasé muy bien! ¡Buenas noches!",idioma:"Thank you for a lovely evening! Have a great night!",audio:appConstants.serverURL+"EN-Coq-10.wav"},
				{castellano:"Eres muy divertido/a",idioma:"You’re funny!",audio:appConstants.serverURL+"EN-Coq-11.wav"},
				{castellano:"Bailas muy bien!",idioma:"You’re great dancer!",audio:appConstants.serverURL+"EN-Coq-12.wav"},
				{castellano:"Ha sido un gusto hablar contigo",idioma:"It’s been really nice talking to you",audio:appConstants.serverURL+"EN-Coq-13.wav"},
				{castellano:"No estoy interesado/a",idioma:"I’m not interested",audio:appConstants.serverURL+"EN-Coq-14.wav"},
				{castellano:"Déjame en paz",idioma:"Leave me alone",audio:appConstants.serverURL+"EN-Coq-15.wav"}
				
			]
		}
				
	 ]
}	

var frances=  {
		info:[
{
	apartado: "Básicas",
	nFilas: 23,
	lineas:[
			
			{castellano:"¿Podría ayudarme?",idioma:"Vous pouvez m’aider, s’il vous plaît?",audio:appConstants.serverURL+"FR-Bas-01.mp3"},
			{castellano:"No entiendo",idioma:"Je ne comprends pas",audio:appConstants.serverURL+"FR-Bas-02.mp3"},
			{castellano:"Hola",idioma:"Bonjour ",audio:appConstants.serverURL+"FR-Bas-03.mp3"},
			{castellano:"Buenos días",idioma:"Bonjour",audio:appConstants.serverURL+"FR-Bas-04.mp3"},
			{castellano:"Buenas tardes",idioma:"Bonsoir",audio:appConstants.serverURL+"FR-Bas-05.mp3"},
			{castellano:"Buenas noches",idioma:"Bonne nuit",audio:appConstants.serverURL+"FR-Bas-06.mp3"},
			{castellano:"¿Cómo estás?",idioma:"Comment vas-tu?",audio:appConstants.serverURL+"FR-Bas-07.mp3"},
			{castellano:"Bien, gracias",idioma:"Bien, merci",audio:appConstants.serverURL+"FR-Bas-08.mp3"},
			{castellano:"¿Cómo te llamas?",idioma:"Comment t’apelles-tu?",audio:appConstants.serverURL+"FR-Bas-09.mp3"},
			{castellano:"Me llamo… ",idioma:"Je m’apelle…",audio:appConstants.serverURL+"FR-Bas-10.mp3"},
			{castellano:"¿De qué país vienes? ",idioma:"D’où viens-tu?",audio:appConstants.serverURL+"FR-Bas-11.mp3"},
			{castellano:"Soy de…",idioma:"Je viens de…",audio:appConstants.serverURL+"FR-Bas-12.mp3"},
			{castellano:"¿Cuántos años tienes?",idioma:"Quel âge as-tu?",audio:appConstants.serverURL+"FR-Bas-13.mp3"},
			{castellano:"Tengo … años",idioma:"J’ai……ans",audio:appConstants.serverURL+"FR-Bas-14.mp3"},
			{castellano:"Sí",idioma:"Qui",audio:appConstants.serverURL+"FR-Bas-15.mp3"},
			{castellano:"No",idioma:"Non",audio:appConstants.serverURL+"FR-Bas-16.mp3"},
			{castellano:"Por favor",idioma:"S’il vous plait",audio:appConstants.serverURL+"FR-Bas-17.mp3"},
			{castellano:"Muchas  gracias",idioma:"Merci beacoup",audio:appConstants.serverURL+"FR-Bas-18.mp3"},
			{castellano:"De nada",idioma:"Je t’en prie",audio:appConstants.serverURL+"FR-Bas-19.mp3"},
			{castellano:"Lo siento",idioma:"Je suis désolé(e)",audio:appConstants.serverURL+"FR-Bas-20.mp3"},
			{castellano:"Disculpe ",idioma:"Excusez-moi",audio:appConstants.serverURL+"FR-Bas-21.mp3"},
			{castellano:"Fue un placer conocerte",idioma:"Ravi(e) de vous avoir rencontré",audio:appConstants.serverURL+"FR-Bas-22.mp3"},
			{castellano:"Adiós ",idioma:"Au revoir!",audio:appConstants.serverURL+"FR-Bas-23.mp3"}			
		]
},{		
	apartado: "Salud",
	nFilas: 13,
	lineas:[
			{castellano:"Necesito ir al hospital",idioma:"Je dois me rendre à l’hôspital",audio:appConstants.serverURL+"FR-Sal-01.mp3"},
			{castellano:"Me siento mal",idioma:"Je me sens malade",audio:appConstants.serverURL+"FR-Sal-02.mp3"},
			{castellano:"Necesito ver a un doctor inmediatamente",idioma:"Je dois voir un médecin inmédiatement",audio:appConstants.serverURL+"FR-Sal-03.mp3"},
			{castellano:"Ayuda",idioma:"Au seccours!",audio:appConstants.serverURL+"FR-Sal-04.mp3"},
			{castellano:"Llamen a una ambulancia",idioma:"Appelez une ambulance",audio:appConstants.serverURL+"FR-Sal-05.mp3"},
			{castellano:"Me duele aquí",idioma:"J’ai mal là",audio:appConstants.serverURL+"FR-Sal-06.mp3"},
			{castellano:"Tengo fiebre",idioma:"J’ai de la fièvre",audio:appConstants.serverURL+"FR-Sal-07.mp3"},
			{castellano:"Tengo un resfriado",idioma:"J’ai un rhume",audio:appConstants.serverURL+"FR-Sal-08.mp3"},
			{castellano:"¿Cuántas veces al día debo tomar esto?",idioma:"Combien de fois par jour dois-je en prendre?",audio:appConstants.serverURL+"FR-Sal-09.mp3"},
			{castellano:"Me siento un poco mejor",idioma:"Je me sens un peu mieux",audio:appConstants.serverURL+"FR-Sal-10.mp3"},
			{castellano:"Ha empeorado",idioma:"C’est pire",audio:appConstants.serverURL+"FR-Sal-11.mp3"},
			{castellano:"Está igual que antes",idioma:"Ill n’y a pas de changement",audio:appConstants.serverURL+"FR-Sal-12.mp3"},
			{castellano:"Tengo tos",idioma:"Je tousse",audio:appConstants.serverURL+"FR-Sal-13.mp3"}										
			]
},{	
	apartado: "Compras",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Cuánto cuesta?",idioma:"Combien ça coûte?",audio:appConstants.serverURL+"FR-Com-01.mp3"},
			{castellano:"¿Tiene algo que sea más barato?",idioma:"Avez-vous quelque chose de moins cher?",audio:appConstants.serverURL+"FR-Com-02.mp3"},
			{castellano:"¿A qué hora abre/cierra?",idioma:"À quelle heure ouvrez/fermez vous?",audio:appConstants.serverURL+"FR-Com-03.mp3"},
			{castellano:"Sólo estoy mirando",idioma:"Je regarde, c’est tout",audio:appConstants.serverURL+"FR-Com-04.mp3"},
			{castellano:"Lo compro",idioma:"Je le prends",audio:appConstants.serverURL+"FR-Com-05.mp3"},
			{castellano:"¿Me puede dar una bolsa, por favor?",idioma:"Je peux avoir un sac, s’il vous plaît?",audio:appConstants.serverURL+"FR-Com-06.mp3"},
			{castellano:"Me gustaría devolver esto",idioma:"Je voudrais échanger cet article",audio:appConstants.serverURL+"FR-Com-07.mp3"},
			{castellano:"¿Dónde se encuentran los probadores?",idioma:"Où sont les cabines d’essayage?",audio:appConstants.serverURL+"FR-Com-08.mp3"}		
			]
},{			
	apartado: "Comer",
	nFilas: 7,
	lineas:[
			{castellano:"Me gustaría reservar una mesa para … personas a las …",idioma:"Je voudrais réserver une table pour …. à … ",audio:appConstants.serverURL+"FR-SalirComer-01.mp3"},
			{castellano:"¿Puedo ver el menú?",idioma:"Je peux avoir la carte?",audio:appConstants.serverURL+"FR-SalirComer-02.mp3"},
			{castellano:"Disculpe, nos gustaría pedir",idioma:"Excusez moi, nous aimerions commmander, s’il vous plaît?",audio:appConstants.serverURL+"FR-SalirComer-03.mp3"},
			{castellano:"Nos gustaría pagar la cuenta",idioma:"Nous voudrions payer, s’il vous plaît?",audio:appConstants.serverURL+"FR-SalirComer-04.mp3"},
			{castellano:"Quédese con el cambio",idioma:"Gardez la monnaie",audio:appConstants.serverURL+"FR-SalirComer-05.mp3"},
			{castellano:"La comida estuvo deliciosa",idioma:"Le repas était délicieux",audio:appConstants.serverURL+"FR-SalirComer-06.mp3"},
			{castellano:"Yo no pedí esto",idioma:"Ce n’est pas ce que j’ai demandé",audio:appConstants.serverURL+"FR-SalirComer-07.mp3"}		
			]
},{		
	apartado: "Hospedaje",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Où puis je trouver …?",audio:appConstants.serverURL+"FR-Hos-01.mp3"},
			{castellano:"¿Tiene habitaciones disponibles?",idioma:"Avez vous des chambres libres?",audio:appConstants.serverURL+"FR-Hos-02.mp3"},
			{castellano:"¿Cuál es el precio de una habitación para … personas?",idioma:"Combien coûte une chambre pour … personnes?",audio:appConstants.serverURL+"FR-Hos-03.mp3"},
			{castellano:"Me gustaría reservar",idioma:"Je voudrais réserver",audio:appConstants.serverURL+"FR-Hos-04.mp3"},
			{castellano:"¿El desayuno está incluido?",idioma:"Le petit-déjeuner est inclus?",audio:appConstants.serverURL+"FR-Hos-05.mp3"},
			{castellano:"No hay agua caliente",idioma:"Il n’y a pas d’eau chaude",audio:appConstants.serverURL+"FR-Hos-06.mp3"},
			{castellano:"El aire acondicionado no funciona",idioma:"La climatisation ne fonctionne pas",audio:appConstants.serverURL+"FR-Hos-07.mp3"},
			{castellano:"Mi llave no funciona",idioma:"Ma clé ne fonctionne pas",audio:appConstants.serverURL+"FR-Hos-08.mp3"}		
			]
},/*{		
	apartado: "Números",
	nFilas: 12,
	lineas:[		
			{castellano:"Uno",idioma:"Un",audio:appConstants.serverURL+"FR-Num-01.mp3"},
			{castellano:"Dos",idioma:"Deux ",audio:appConstants.serverURL+"FR-Num-02.mp3"},
			{castellano:"Tres ",idioma:"Trois",audio:appConstants.serverURL+"FR-Num-03.mp3"},
			{castellano:"Cuatro",idioma:"Quatre",audio:appConstants.serverURL+"FR-Num-04.mp3"},
			{castellano:"Cinco",idioma:"Cinq",audio:appConstants.serverURL+"FR-Num-05.mp3"},
			{castellano:"Seis",idioma:"Six ",audio:appConstants.serverURL+"FR-Num-06.mp3"},
			{castellano:"Siete	",idioma:"Sept",audio:appConstants.serverURL+"FR-Num-07.mp3"},
			{castellano:"Ocho ",idioma:"Huit",audio:appConstants.serverURL+"FR-Num-08.mp3"},
			{castellano:"Nueve ",idioma:"Neuf",audio:appConstants.serverURL+"FR-Num-09.mp3"},
			{castellano:"Diez",idioma:"Dix",audio:appConstants.serverURL+"FR-Num-10.mp3"},
			{castellano:"Cien ",idioma:"Cent",audio:appConstants.serverURL+"FR-Num-11.mp3"},
			{castellano:"Millón ",idioma:"Million",audio:appConstants.serverURL+"FR-Num-13.mp3"}
			
			]
},*/{
			
	apartado: "Viajar",
	nFilas: 11,
	lineas:[			
			{castellano:"Estoy perdido",idioma:"Je suis perdu",audio:appConstants.serverURL+"FR-Via-01.mp3"},
			{castellano:"¿Me puede mostrar su ubicación en el mapa?",idioma:"Vous pouvez me monter où c’est sour le plan?",audio:appConstants.serverURL+"FR-Via-02.mp3"},
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Oú puis-je trouver …?",audio:appConstants.serverURL+"FR-Via-03.mp3"},
			{castellano:"¿Cómo llego a …?",idioma:"Comment je peux me rendre …?",audio:appConstants.serverURL+"FR-Via-04.mp3"},
			{castellano:"Gire a la izquierda ",idioma:"Tournez á la gauche",audio:appConstants.serverURL+"FR-Via-05.mp3"},
			{castellano:"Gire a la derecha",idioma:"Tournez á la droite ",audio:appConstants.serverURL+"FR-Via-06.mp3"},
			{castellano:"Siga derecho",idioma:"Allez tout droit",audio:appConstants.serverURL+"FR-Via-07.mp3"},
			{castellano:"Regrese",idioma:"Faites demi-tour",audio:appConstants.serverURL+"FR-Via-08.mp3"},
			{castellano:"¿Dónde puedo comprar un ticket para el autobús/tren?",idioma:"Où puis-je acheter un ticket de bus/train?",audio:appConstants.serverURL+"FR-Via-00.mp3"},
			{castellano:"¿Está ocupado este asiento?",idioma:"Ce siège est-il pris?",audio:appConstants.serverURL+"FR-Via-10.mp3"},
			{castellano:"Ese es mi asiento",idioma:"C’est mon siège",audio:appConstants.serverURL+"FR-Via-11.mp3"}
			
			]
},{	
	apartado: "Quejas",
	nFilas: 5,
	lineas:[
			{castellano:"Me gustaría realizar una queja",idioma:"Je voudrais faire une réclamation",audio:appConstants.serverURL+"FR-Que-01.mp3"},
			{castellano:"¿Quién es el encargado?",idioma:"Qui est le reponsable ici?",audio:appConstants.serverURL+"FR-Que-02.mp3"},
			{castellano:"Esto es totalmente inaceptable",idioma:"C’est absolument inacceptable",audio:appConstants.serverURL+"FR-Que-03.mp3"},
			{castellano:"Quiero mi dinero de vuelta",idioma:"J’exige un remboursement",audio:appConstants.serverURL+"FR-Que-04.mp3"},
			{castellano:"Hemos estado esperando por más de una hora",idioma:"Cela fait plus d’une heure que nous attendons",audio:appConstants.serverURL+"FR-Que-05.mp3"},					
		]
	 },{		
	apartado: "Coqueteo",
	nFilas: 15,
	lineas:[					
			{castellano:"¿Te puedo invitar a algo para beber?",idioma:"Je peux vous offrir un verre?",audio:appConstants.serverURL+"FR-Coq-01.mp3"},
			{castellano:"¿A qué te dedicas?",idioma:"Vous faites quoi dans la vie?",audio:appConstants.serverURL+"FR-Coq-02.mp3"},
			{castellano:"¿Quieres bailar?",idioma:"Vous voulez danser?",audio:appConstants.serverURL+"FR-Coq-03.mp3"},
			{castellano:"¿Te gustaría salir un poco?",idioma:"On sort prendre l’air?",audio:appConstants.serverURL+"FR-Coq-04.mp3"},
			{castellano:"¿Vamos a mi casa o a la tuya?",idioma:"Chez toi ou chez moi?",audio:appConstants.serverURL+"FR-Coq-05.mp3"},
			{castellano:"¿Te gustaría ver una película en mi casa?",idioma:"Tu veux venir voir un film chez moi?",audio:appConstants.serverURL+"FR-Coq-06.mp3"},
			{castellano:"¿Tienes algún plan para esta noche?",idioma:"Tu as quelque chose de prévu ce soir?",audio:appConstants.serverURL+"FR-Coq-07.mp3"},
			{castellano:"¿Te gustaría ir a tomar un café?",idioma:"Tu veux aller prendre un café?",audio:appConstants.serverURL+"FR-Coq-08.mp3"},
			{castellano:"¿Te llevo/acompaño a tu casa?",idioma:"Je peux te conduire/ramener chez toi?",audio:appConstants.serverURL+"FR-Coq-09.mp3"},
			{castellano:"¡Me lo pasé muy bien! ¡Buenas noches!",idioma:"Merci pour cette charmante soirée. Bonne nuit!",audio:appConstants.serverURL+"FR-Coq-10.mp3"},
			{castellano:"Eres muy divertido/a",idioma:"Tu es tellement drôle!",audio:appConstants.serverURL+"FR-Coq-11.mp3"},
			{castellano:"Bailas muy bien!",idioma:"Tu es un trés un bone danseur!",audio:appConstants.serverURL+"FR-Coq-12.mp3"},
			{castellano:"Ha sido un gusto hablar contigo",idioma:"C’étais sympa de discuter avec toi",audio:appConstants.serverURL+"FR-Coq-13.mp3"},
			{castellano:"No estoy interesado/a",idioma:"Je ne suis pas intéressé(e)",audio:appConstants.serverURL+"FR-Coq-14.mp3"},
			{castellano:"Déjame en paz",idioma:"Laisse-moi tranquille",audio:appConstants.serverURL+"FR-Coq-15.mp3"}
			]
	}
]
}

var aleman=  {
		info:[
{
	apartado: "Básicas",
	nFilas: 23,
	lineas:[
			
			{castellano:"¿Podría ayudarme?",idioma:"Können Sie mir bitte helfen?",audio:appConstants.serverURL+"DE-Bas-01.mp3"},
			{castellano:"No entiendo",idioma:"Das verstehe ich nicht",audio:appConstants.serverURL+"DE-Bas-02.mp3"},
			{castellano:"Hola",idioma:"Hallo ",audio:appConstants.serverURL+"DE-Bas-03.mp3"},
			{castellano:"Buenos días",idioma:"Guten Morgen",audio:appConstants.serverURL+"DE-Bas-04.mp3"},
			{castellano:"Buenas tardes",idioma:"Guten Abend",audio:appConstants.serverURL+"DE-Bas-05.mp3"},
			{castellano:"Buenas noches",idioma:"Gute Nacht",audio:appConstants.serverURL+"DE-Bas-06.mp3"},
			{castellano:"¿Cómo estás?",idioma:"Wie geht es Dir?",audio:appConstants.serverURL+"DE-Bas-07.mp3"},
			{castellano:"Bien, gracias",idioma:"Gut, danke",audio:appConstants.serverURL+"DE-Bas-08.mp3"},
			{castellano:"¿Cómo te llamas?",idioma:"Wie heibt du?",audio:appConstants.serverURL+"DE-Bas-09.mp3"},
			{castellano:"Me llamo… ",idioma:"Mein Name ist …",audio:appConstants.serverURL+"DE-Bas-10.mp3"},
			{castellano:"¿De qué país vienes? ",idioma:"Woher kommst Du?",audio:appConstants.serverURL+"DE-Bas-12.mp3"},
			{castellano:"Soy de…",idioma:"Ich bin aus …",audio:appConstants.serverURL+"DE-Bas-13.mp3"},
			{castellano:"¿Cuántos años tienes?",idioma:"Wie alt bist du?",audio:appConstants.serverURL+"DE-Bas-13.mp3"},
			{castellano:"Tengo … años",idioma:"Ich bin … Jahre alt",audio:appConstants.serverURL+"DE-Bas-14.mp3"},
			{castellano:"Sí",idioma:"Ja",audio:appConstants.serverURL+"DE-Bas-15.mp3"},
			{castellano:"No",idioma:"Nein",audio:appConstants.serverURL+"DE-Bas-16.mp3"},
			{castellano:"Por favor",idioma:"Bitte",audio:appConstants.serverURL+"DE-Bas-17.mp3"},
			{castellano:"Muchas  gracias",idioma:"Vielen Dank",audio:appConstants.serverURL+"DE-Bas-18.mp3"},
			{castellano:"De nada",idioma:"Gern geschehen",audio:appConstants.serverURL+"DE-Bas-19.mp3"},
			{castellano:"Lo siento",idioma:"Es tut mir Leid",audio:appConstants.serverURL+"DE-Bas-20.mp3"},
			{castellano:"Disculpe ",idioma:"Entschuldigung",audio:appConstants.serverURL+"DE-Bas-21.mp3"},
			{castellano:"Fue un placer conocerte",idioma:"Es war nett, Sie kennenzulernen",audio:appConstants.serverURL+"DE-Bas-22.mp3"},
			{castellano:"Adiós ",idioma:"Auf Wiedersehen",audio:appConstants.serverURL+"DE-Bas-23.mp3"}
			
		]
},{
			
	apartado: "Salud",
	nFilas: 13,
	lineas:[
			{castellano:"Necesito ir al hospital",idioma:"Ich muss ein Krankhaus",audio:appConstants.serverURL+"DE-Sal-01.mp3"},
			{castellano:"Me siento mal",idioma:"Mir ist übel",audio:appConstants.serverURL+"DE-Sal-02.mp3"},
			{castellano:"Necesito ver a un doctor inmediatamente",idioma:"Ich muss sofort zu einem Arzt",audio:appConstants.serverURL+"DE-Sal-03.mp3"},
			{castellano:"Ayuda",idioma:"Hilfe",audio:appConstants.serverURL+"DE-Sal-04.mp3"},
			{castellano:"Llamen a una ambulancia",idioma:"Ruf einen Krankenwagen",audio:appConstants.serverURL+"DE-Sal-05.mp3"},
			{castellano:"Me duele aquí",idioma:"Es tut hier weh",audio:appConstants.serverURL+"DE-Sal-06.mp3"},
			{castellano:"Tengo fiebre",idioma:"Ich habe Fieber",audio:appConstants.serverURL+"DE-Sal-07.mp3"},
			{castellano:"Tengo un resfriado",idioma:"Ich habe Erkältung",audio:appConstants.serverURL+"DE-Sal-08.mp3"},
			{castellano:"¿Cuántas veces al día debo tomar esto?",idioma:"Wie oft soll ich die am Tag einnehmen?",audio:appConstants.serverURL+"DE-Sal-09.mp3"},
			{castellano:"Me siento un poco mejor",idioma:"Ich fühle mich etwas besser",audio:appConstants.serverURL+"DE-Sal-10.mp3"},
			{castellano:"Ha empeorado",idioma:"Es ist geworden",audio:appConstants.serverURL+"DE-Sal-11.mp3"},
			{castellano:"Está igual que antes",idioma:"Est ist unverändert ",audio:appConstants.serverURL+"DE-Sal-12.mp3"},
			{castellano:"Tengo tos",idioma:"Ich habe Husten",audio:appConstants.serverURL+"DE-Sal-13.mp3"}
										
			]
},{
		
	apartado: "Compras",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Cuánto cuesta?",idioma:"Wieviel kostet das?",audio:appConstants.serverURL+"DE-Com-01.mp3"},
			{castellano:"¿Tiene algo que sea más barato?",idioma:"Haben Sie etwas, dass nicht so teuer ist?",audio:appConstants.serverURL+"DE-Com-02.mp3"},
			{castellano:"¿A qué hora abre/cierra?",idioma:"Um wieviel Uhr öffnen/schlieben Sie?",audio:appConstants.serverURL+"DE-Com-03.mp3"},
			{castellano:"Sólo estoy mirando",idioma:"Um wieviel mich nur um",audio:appConstants.serverURL+"DE-Com-04.mp3"},
			{castellano:"Lo compro",idioma:"Ich werde es kaufen",audio:appConstants.serverURL+"DE-Com-05.mp3"},
			{castellano:"¿Me puede dar una bolsa, por favor?",idioma:"Kann ich bitte eine Tüte haben?",audio:appConstants.serverURL+"DE-Com-06.mp3"},
			{castellano:"Me gustaría devolver esto",idioma:"Ich möchte das gerne umtauschen",audio:appConstants.serverURL+"DE-Com-07.mp3"},
			{castellano:"¿Dónde se encuentran los probadores?",idioma:"Wo sind die Umkleidekabinen?",audio:appConstants.serverURL+"DE-Com-08.mp3"}
			
			]
},{
			
	apartado: "Comer",
	nFilas: 7,
	lineas:[
			{castellano:"Me gustaría reservar una mesa para … personas a las …",idioma:"Ich würde gern einen Tisch für … personen um … reservieren",audio:appConstants.serverURL+"DE-SalirComer-01.mp3"},
			{castellano:"¿Puedo ver el menú?",idioma:"Kann ich die Speisekarte haben, bitte?",audio:appConstants.serverURL+"DE-SalirComer-02.mp3"},
			{castellano:"Disculpe, nos gustaría pedir",idioma:"Entschuldigung, wir würden gern bestellen, bitte",audio:appConstants.serverURL+"DE-SalirComer-03.mp3"},
			{castellano:"Nos gustaría pagar la cuenta",idioma:"Wir möchten gern bezahlen, bitte",audio:appConstants.serverURL+"DE-SalirComer-04.mp3"},
			{castellano:"Quédese con el cambio",idioma:"Der Rest ist für Sie",audio:appConstants.serverURL+"DE-SalirComer-05.mp3"},
			{castellano:"La comida estuvo deliciosa",idioma:"Das Essen war lecker",audio:appConstants.serverURL+"DE-SalirComer-06.mp3"},
			{castellano:"Yo no pedí esto",idioma:"Das habe ich nicht bestellt",audio:appConstants.serverURL+"DE-SalirComer-07.mp3"}
			
			]
},{
			
	apartado: "Hospedaje",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Wo kann ich … finden?",audio:appConstants.serverURL+"DE-Hos-01.mp3"},
			{castellano:"¿Tiene habitaciones disponibles?",idioma:"Sind irgendwelche Zimmer frei?",audio:appConstants.serverURL+"DE-Hos-02.mp3"},
			{castellano:"¿Cuál es el precio de una habitación para … personas?",idioma:"Wieviel kostet ein Zimmer für … Personen?",audio:appConstants.serverURL+"DE-Hos-03.mp3"},
			{castellano:"Me gustaría reservar",idioma:"Ich würde gern",audio:appConstants.serverURL+"DE-Hos-04.mp3"},
			{castellano:"¿El desayuno está incluido?",idioma:"Ist Frühstück inklusive?",audio:appConstants.serverURL+"DE-Hos-05.mp3"},
			{castellano:"No hay agua caliente",idioma:"Es gibt kein heibes Wasser",audio:appConstants.serverURL+"DE-Hos-06.mp3"},
			{castellano:"El aire acondicionado no funciona",idioma:"Die Klimaanlage funktioniert nicht",audio:appConstants.serverURL+"DE-Hos-07.mp3"},
			{castellano:"Mi llave no funciona",idioma:"Des Shlüssel funktioniert nicht",audio:appConstants.serverURL+"DE-Hos-08.mp3"}
			
			]
},/*{
			
	apartado: "Números",
	nFilas: 12,
	lineas:[		
			{castellano:"Uno",idioma:"Eins",audio:appConstants.serverURL+"DE-Num-01.mp3"},
			{castellano:"Dos",idioma:"Zwei",audio:appConstants.serverURL+"DE-Num-02.mp3"},
			{castellano:"Tres ",idioma:"Drei",audio:appConstants.serverURL+"DE-Num-03.mp3"},
			{castellano:"Cuatro",idioma:"Vier",audio:appConstants.serverURL+"DE-Num-04.mp3"},
			{castellano:"Cinco",idioma:"Fünf",audio:appConstants.serverURL+"DE-Num-05.mp3"},
			{castellano:"Seis",idioma:"Sechs",audio:appConstants.serverURL+"DE-Num-06.mp3"},
			{castellano:"Siete	",idioma:"Sieben",audio:appConstants.serverURL+"DE-Num-07.mp3"},
			{castellano:"Ocho ",idioma:"Acht",audio:appConstants.serverURL+"DE-Num-08.mp3"},
			{castellano:"Nueve ",idioma:"Neun",audio:appConstants.serverURL+"DE-Num-09.mp3"},
			{castellano:"Diez",idioma:"Zehn",audio:appConstants.serverURL+"DE-Num-11.mp3"},
			{castellano:"Cien ",idioma:"Hundert",audio:appConstants.serverURL+"DE-Num-11.mp3"},
			{castellano:"Millón ",idioma:"Million",audio:appConstants.serverURL+"DE-Num-12.mp3"}
			
			]
},*/{
			
	apartado: "Viajar",
	nFilas: 11,
	lineas:[			
			{castellano:"Estoy perdido",idioma:"Ich habe mich verirrt",audio:appConstants.serverURL+"DE-Via-01.mp3"},
			{castellano:"¿Me puede mostrar su ubicación en el mapa?",idioma:"Können Si emir zeigen, wo das auf der Karte ist?",audio:appConstants.serverURL+"DE-Via-02.mp3"},
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Wo kann ich … finden?",audio:appConstants.serverURL+"DE-Via-03.mp3"},
			{castellano:"¿Cómo llego a …?",idioma:"Wie komme ich zum/zur ...?",audio:appConstants.serverURL+"DE-Via-04.mp3"},
			{castellano:"Gire a la izquierda ",idioma:"Nach links",audio:appConstants.serverURL+"DE-Via-05.mp3"},
			{castellano:"Gire a la derecha",idioma:"Nach rechts",audio:appConstants.serverURL+"DE-Via-06.mp3"},
			{castellano:"Siga derecho",idioma:"Geradeaus gehen",audio:appConstants.serverURL+"DE-Via-07.mp3"},
			{castellano:"Regrese",idioma:"Geh zurück",audio:appConstants.serverURL+"DE-Via-08.mp3"},
			{castellano:"¿Dónde puedo comprar un ticket para el autobús/tren?",idioma:"Wo kann ich ein Busticket/Zugticket kaufen?",audio:appConstants.serverURL+"DE-Via-09.mp3"},
			{castellano:"¿Está ocupado este asiento?",idioma:"Ist dieser Platz besetzt?",audio:appConstants.serverURL+"DE-Via-10.mp3"},
			{castellano:"Ese es mi asiento",idioma:"Das ist mein Platz",audio:appConstants.serverURL+"DE-Via-11.mp3"}
			
			]
},{	
	apartado: "Quejas",
	nFilas: 5,
	lineas:[
			{castellano:"Me gustaría realizar una queja",idioma:"Ich möchte mich beschweren",audio:appConstants.serverURL+"DE-Que-01.mp3"},
			{castellano:"¿Quién es el encargado?",idioma:"Wer ist hier der Verantworliche?",audio:appConstants.serverURL+"DE-Que-02.mp3"},
			{castellano:"Esto es totalmente inaceptable",idioma:"Das ist wirklich inakzeptabel",audio:appConstants.serverURL+"DE-Que-03.mp3"},
			{castellano:"Quiero mi dinero de vuelta",idioma:"Ich will mein Geld zurück",audio:appConstants.serverURL+"DE-Que-04.mp3"},
			{castellano:"Hemos estado esperando por más de una hora",idioma:"Wir warten seit über einer Stunde",audio:appConstants.serverURL+"DE-Que-05.mp3"},					
		]
	 },{
			
	apartado: "Coqueteo",
	nFilas: 15,
	lineas:[					
			{castellano:"¿Te puedo invitar a algo para beber?",idioma:"Darf ich Dir ein Getränk ausgeben?",audio:appConstants.serverURL+"DE-Coq-01.mp3"},
			{castellano:"¿A qué te dedicas?",idioma:"Und, was machst du beruflich?",audio:appConstants.serverURL+"DE-Coq-02.mp3"},
			{castellano:"¿Quieres bailar?",idioma:"Willst Du tanzen?",audio:appConstants.serverURL+"DE-Coq-03.mp3"},
			{castellano:"¿Te gustaría salir un poco?",idioma:"Möchtest du kurz rausgehen?",audio:appConstants.serverURL+"DE-Coq-04.mp3"},
			{castellano:"¿Vamos a mi casa o a la tuya?",idioma:"Zu mir oder zu dir?",audio:appConstants.serverURL+"DE-Coq-05.mp3"},
			{castellano:"¿Te gustaría ver una película en mi casa?",idioma:"Möchtest Du bei mir einen Film shauen?",audio:appConstants.serverURL+"DE-Coq-06.mp3"},
			{castellano:"¿Tienes algún plan para esta noche?",idioma:"Hast Du heute Abend etwas vor?",audio:appConstants.serverURL+"DE-Coq-07.mp3"},
			{castellano:"¿Te gustaría ir a tomar un café?",idioma:"Würdest Du mit mir einen Kaffe trinken gehen? ",audio:appConstants.serverURL+"DE-Coq-08.mp3"},
			{castellano:"¿Te llevo/acompaño a tu casa?",idioma:"Kann ich Dich nach Hause begleiten/fahren?",audio:appConstants.serverURL+"DE-Coq-09.mp3"},
			{castellano:"¡Me lo pasé muy bien! ¡Buenas noches!",idioma:"Danke für den schönen Abend. Gute Nacht!",audio:appConstants.serverURL+"DE-Coq-10.mp3"},
			{castellano:"Eres muy divertido/a",idioma:"Du bist lustig!",audio:appConstants.serverURL+"DE-Coq-11.mp3"},
			{castellano:"Bailas muy bien!",idioma:"Du bist eine gute Tänzerin/ein guter Tänzer!",audio:appConstants.serverURL+"DE-Coq-12.mp3"},
			{castellano:"Ha sido un gusto hablar contigo",idioma:"Es war shön, mit Dir zu reden",audio:appConstants.serverURL+"DE-Coq-13.mp3"},
			{castellano:"No estoy interesado/a",idioma:"Ich habe kein Interesse",audio:appConstants.serverURL+"DE-Coq-14.mp3"},
			{castellano:"Déjame en paz",idioma:"Lass mich in Ruhe",audio:appConstants.serverURL+"DE-Coq-15.mp3"}
			]
	}
]
}

var italiano=  {
		info:[
{
	apartado: "Básicas",
	nFilas: 23,
	lineas:[
			
			{castellano:"¿Podría ayudarme?",idioma:"Può aiutarmi?",audio:appConstants.serverURL+"IT-Bas-01.mp3"},
			{castellano:"No entiendo",idioma:"Non capisco",audio:appConstants.serverURL+"IT-Bas-02.mp3"},
			{castellano:"Hola",idioma:"Salve/Ciao",audio:appConstants.serverURL+"IT-Bas-03.mp3"},
			{castellano:"Buenos días",idioma:"Buon giorno",audio:appConstants.serverURL+"IT-Bas-04.mp3"},
			{castellano:"Buenas tardes",idioma:"Buona sera",audio:appConstants.serverURL+"IT-Bas-05.mp3"},
			{castellano:"Buenas noches",idioma:"Buona notte",audio:appConstants.serverURL+"IT-Bas-06.mp3"},
			{castellano:"¿Cómo estás?",idioma:"Come va?",audio:appConstants.serverURL+"IT-Bas-07.mp3"},
			{castellano:"Bien, gracias",idioma:"Bene, grazie",audio:appConstants.serverURL+"IT-Bas-08.mp3"},
			{castellano:"¿Cómo te llamas?",idioma:"Come ti chiami?",audio:appConstants.serverURL+"IT-Bas-09.mp3"},
			{castellano:"Me llamo… ",idioma:"Mi chiamo …",audio:appConstants.serverURL+"IT-Bas-10.mp3"},
			{castellano:"¿De qué país vienes? ",idioma:"Da dove vieni?",audio:appConstants.serverURL+"IT-Bas-11.mp3"},
			{castellano:"Soy de…",idioma:"Vengo da …",audio:appConstants.serverURL+"IT-Bas-12.mp3"},
			{castellano:"¿Cuántos años tienes?",idioma:"Cuanti anni hai?",audio:appConstants.serverURL+"IT-Bas-13.mp3"},
			{castellano:"Tengo … años",idioma:"Ho …. anni",audio:appConstants.serverURL+"IT-Bas-14.mp3"},
			{castellano:"Sí",idioma:"Si",audio:appConstants.serverURL+"IT-Bas-15.mp3"},
			{castellano:"No",idioma:"No",audio:appConstants.serverURL+"IT-Bas-16.mp3"},
			{castellano:"Por favor",idioma:"Per favore",audio:appConstants.serverURL+"IT-Bas-17.mp3"},
			{castellano:"Muchas  gracias",idioma:"Grazie mille",audio:appConstants.serverURL+"IT-Bas-18.mp3"},
			{castellano:"De nada",idioma:"Prego",audio:appConstants.serverURL+"IT-Bas-19.mp3"},
			{castellano:"Lo siento",idioma:"Mi dispiace",audio:appConstants.serverURL+"IT-Bas-20.mp3"},
			{castellano:"Disculpe ",idioma:"Mi scusi",audio:appConstants.serverURL+"IT-Bas-21.mp3"},
			{castellano:"Fue un placer conocerte",idioma:"E’ stato un piacere conoscerti",audio:appConstants.serverURL+"IT-Bas-22.mp3"},
			{castellano:"Adiós ",idioma:"Arrivederci",audio:appConstants.serverURL+"IT-Bas-23.mp3"}
			
		]
},{
			
	apartado: "Salud",
	nFilas: 13,
	lineas:[
			{castellano:"Necesito ir al hospital",idioma:"Debo andare in ospedale",audio:appConstants.serverURL+"IT-Sal-01.mp3"},
			{castellano:"Me siento mal",idioma:"Non mi sento bene",audio:appConstants.serverURL+"IT-Sal-02.mp3"},
			{castellano:"Necesito ver a un doctor inmediatamente",idioma:"Ho bisogno di un dottore subito",audio:appConstants.serverURL+"IT-Sal-03.mp3"},
			{castellano:"Ayuda",idioma:"Aiuto",audio:appConstants.serverURL+"IT-Sal-04.mp3"},
			{castellano:"Llamen a una ambulancia",idioma:"Chiamate un’ambulanza",audio:appConstants.serverURL+"IT-Sal-05.mp3"},
			{castellano:"Me duele aquí",idioma:"Mi fa male qui",audio:appConstants.serverURL+"IT-Sal-06.mp3"},
			{castellano:"Tengo fiebre",idioma:"Ho la febbre",audio:appConstants.serverURL+"IT-Sal-07.mp3"},
			{castellano:"Tengo un resfriado",idioma:"Ho il raffreddore",audio:appConstants.serverURL+"IT-Sal-08.mp3"},
			{castellano:"¿Cuántas veces al día debo tomar esto?",idioma:"Cuante volte al giorno devo prenderla?",audio:appConstants.serverURL+"IT-Sal-09.mp3"},
			{castellano:"Me siento un poco mejor",idioma:"Mi sento un po’meglio",audio:appConstants.serverURL+"IT-Sal-10.mp3"},
			{castellano:"Ha empeorado",idioma:"Sto peggiorando",audio:appConstants.serverURL+"IT-Sal-11.mp3"},
			{castellano:"Está igual que antes",idioma:"Non è cambiato nulla",audio:appConstants.serverURL+"IT-Sal-12.mp3"},
			{castellano:"Tengo tos",idioma:"Ho la tosse",audio:appConstants.serverURL+"IT-Sal-13.mp3"}
										
			]
},{
		
	apartado: "Compras",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Cuánto cuesta?",idioma:"Quanto costa questo?",audio:appConstants.serverURL+"IT-Comp-01.mp3"},
			{castellano:"¿Tiene algo que sea más barato?",idioma:"Avete qualcosa di meno costoso?",audio:appConstants.serverURL+"IT-Comp-02.mp3"},
			{castellano:"¿A qué hora abre/cierra?",idioma:"A che ora aprite/chiudete?",audio:appConstants.serverURL+"IT-Comp-03.mp3"},
			{castellano:"Sólo estoy mirando",idioma:"Sto dando un’occhiata",audio:appConstants.serverURL+"IT-Comp-04.mp3"},
			{castellano:"Lo compro",idioma:"Lo compro",audio:appConstants.serverURL+"IT-Comp-05.mp3"},
			{castellano:"¿Me puede dar una bolsa, por favor?",idioma:"Mi può dare una borsa?",audio:appConstants.serverURL+"IT-Comp-06.mp3"},
			{castellano:"Me gustaría devolver esto",idioma:"Vorrei restituire questo",audio:appConstants.serverURL+"IT-Comp-07.mp3"},
			{castellano:"¿Dónde se encuentran los probadores?",idioma:"Dove sono i camerini di prova?",audio:appConstants.serverURL+"IT-Comp-08.mp3"}
			
			]
},{
			
	apartado: "Comer",
	nFilas: 7,
	lineas:[
			{castellano:"Me gustaría reservar una mesa para … personas a las …",idioma:"Vorrei prenotare un tavolo per … per …",audio:appConstants.serverURL+"IT-Salircomer-01.mp3"},
			{castellano:"¿Puedo ver el menú?",idioma:"Mi porta il menú?",audio:appConstants.serverURL+"IT-Salircomer-02.mp3"},
			{castellano:"Disculpe, nos gustaría pedir",idioma:"Scusi. Vorremmo ordinare",audio:appConstants.serverURL+"IT-Salircomer-03.mp3"},
			{castellano:"Nos gustaría pagar la cuenta",idioma:"Il conto, per favore",audio:appConstants.serverURL+"IT-Salircomer-04.mp3"},
			{castellano:"Quédese con el cambio",idioma:"Puoi tenere la mancia",audio:appConstants.serverURL+"IT-Salircomer-05.mp3"},
			{castellano:"La comida estuvo deliciosa",idioma:"Il cibo era delizioso",audio:appConstants.serverURL+"IT-Salircomer-06.mp3"},
			{castellano:"Yo no pedí esto",idioma:"Non ho ordinato questo",audio:appConstants.serverURL+"IT-Salircomer-07.mp3"}
			
			]
},{
			
	apartado: "Hospedaje",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Dovo posso trovare …?",audio:appConstants.serverURL+"IT-Hos-01.mp3"},
			{castellano:"¿Tiene habitaciones disponibles?",idioma:"Avete camere libre?",audio:appConstants.serverURL+"IT-Hos-02.mp3"},
			{castellano:"¿Cuál es el precio de una habitación para … personas?",idioma:"Quanto costa una camera per … persone?",audio:appConstants.serverURL+"IT-Hos-03.mp3"},
			{castellano:"Me gustaría reservar",idioma:"Vorrei prenotare",audio:appConstants.serverURL+"IT-Hos-04.mp3"},
			{castellano:"¿El desayuno está incluido?",idioma:"La colazione è inclusa?",audio:appConstants.serverURL+"IT-Hos-05.mp3"},
			{castellano:"No hay agua caliente",idioma:"Non c’é l’acqua calda",audio:appConstants.serverURL+"IT-Hos-06.mp3"},
			{castellano:"El aire acondicionado no funciona",idioma:"L’ aria condizionata non funziona",audio:appConstants.serverURL+"IT-Hos-07.mp3"},
			{castellano:"Mi llave no funciona",idioma:"La mia chiave non entra nella serratura",audio:appConstants.serverURL+"IT-Hos-08.mp3"}
			
			]
},/*{
			
	apartado: "Números",
	nFilas: 12,
	lineas:[		
			{castellano:"Uno",idioma:"Uno",audio:appConstants.serverURL+"IT-Num-01.mp3"},
			{castellano:"Dos",idioma:"Due",audio:appConstants.serverURL+"IT-Num-02.mp3"},
			{castellano:"Tres ",idioma:"Tre",audio:appConstants.serverURL+"IT-Num-03.mp3"},
			{castellano:"Cuatro",idioma:"Quattro",audio:appConstants.serverURL+"IT-Num-04.mp3"},
			{castellano:"Cinco",idioma:"Cinque",audio:appConstants.serverURL+"IT-Num-05.mp3"},
			{castellano:"Seis",idioma:"Sei",audio:appConstants.serverURL+"IT-Num-06.mp3"},
			{castellano:"Siete	",idioma:"Sette",audio:appConstants.serverURL+"IT-Num-07.mp3"},
			{castellano:"Ocho",idioma:"Otto",audio:appConstants.serverURL+"IT-Num-08.mp3"},
			{castellano:"Nueve",idioma:"Nove",audio:appConstants.serverURL+"IT-Num-09.mp3"},
			{castellano:"Diez",idioma:"Dieci",audio:appConstants.serverURL+"IT-Num-10.mp3"},
			{castellano:"Cien",idioma:"Cento",audio:appConstants.serverURL+"IT-Num-11.mp3"},
			{castellano:"Millón",idioma:"Milione",audio:appConstants.serverURL+"IT-Num-12.mp3"}
			
			]
},*/{
			
	apartado: "Viajar",
	nFilas: 11,
	lineas:[			
			{castellano:"Estoy perdido",idioma:"Mi sono perso",audio:appConstants.serverURL+"IT-Via-01.mp3"},
			{castellano:"¿Me puede mostrar su ubicación en el mapa?",idioma:"Può mostrarmi dov’è sulla cartina?",audio:appConstants.serverURL+"IT-Via-02.mp3"},
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Dove posso trovare …?",audio:appConstants.serverURL+"IT-Via-03.mp3"},
			{castellano:"¿Cómo llego a …?",idioma:"Come si arriva …?",audio:appConstants.serverURL+"IT-Via-04.mp3"},
			{castellano:"Gire a la izquierda ",idioma:"Gira a sinistra",audio:appConstants.serverURL+"IT-Via-05.mp3"},
			{castellano:"Gire a la derecha",idioma:"Gira a destra",audio:appConstants.serverURL+"IT-Via-06.mp3"},
			{castellano:"Siga derecho",idioma:"Sempre dritto",audio:appConstants.serverURL+"IT-Via-07.mp3"},
			{castellano:"Regrese",idioma:"Torna indietro",audio:appConstants.serverURL+"IT-Via-08.mp3"},
			{castellano:"¿Dónde puedo comprar un ticket para el autobús/tren?",idioma:"Dove posso comprare un biglietto per l’autobus/per il treno?",audio:appConstants.serverURL+"IT-Via-09.mp3"},
			{castellano:"¿Está ocupado este asiento?",idioma:"E’ occupato questo posto?",audio:appConstants.serverURL+"IT-Via-10.mp3"},
			{castellano:"Ese es mi asiento",idioma:"Questo è il mio posto",audio:appConstants.serverURL+"IT-Via-11.mp3"}
			
			]
},{	
	apartado: "Quejas",
	nFilas: 5,
	lineas:[
			{castellano:"Me gustaría realizar una queja",idioma:"Vorrei fare un reclamo",audio:appConstants.serverURL+"IT-Que-01.mp3"},
			{castellano:"¿Quién es el encargado?",idioma:"Chi é il responsabile qui?",audio:appConstants.serverURL+"IT-Que-02.mp3"},
			{castellano:"Esto es totalmente inaceptable",idioma:"E-davvero inammissibile",audio:appConstants.serverURL+"IT-Que-03.mp3"},
			{castellano:"Quiero mi dinero de vuelta",idioma:"Rivoglio in dietro i miei soldi",audio:appConstants.serverURL+"IT-Que-04.mp3"},
			{castellano:"Hemos estado esperando por más de una hora",idioma:"Stiamo aspettando da piú di un’ora",audio:appConstants.serverURL+"IT-Que-05.mp3"},					
		]
	 },{
			
	apartado: "Coqueteo",
	nFilas: 15,
	lineas:[					
			{castellano:"¿Te puedo invitar a algo para beber?",idioma:"Posso offrirti qualcosa da bere?",audio:appConstants.serverURL+"IT-Coq-01.mp3"},
			{castellano:"¿A qué te dedicas?",idioma:"Cosa fai de bello nella vita?",audio:appConstants.serverURL+"IT-Coq-0w.mp3"},
			{castellano:"¿Quieres bailar?",idioma:"Ti va di ballare?",audio:appConstants.serverURL+"IT-Coq-03.mp3"},
			{castellano:"¿Te gustaría salir un poco?",idioma:"Ti va andrebbe di prendere un po’ d’aria fresca?",audio:appConstants.serverURL+"IT-Coq-04.mp3"},
			{castellano:"¿Vamos a mi casa o a la tuya?",idioma:"A casa mia o a casa tua?",audio:appConstants.serverURL+"IT-Coq-05.mp3"},
			{castellano:"¿Te gustaría ver una película en mi casa?",idioma:"Ti va di guardare un film a casa mia?",audio:appConstants.serverURL+"IT-Coq-06.mp3"},
			{castellano:"¿Tienes algún plan para esta noche?",idioma:"Hay qualcosa in programa per stasera?",audio:appConstants.serverURL+"IT-Coq-07.mp3"},
			{castellano:"¿Te gustaría ir a tomar un café?",idioma:"Ti va di bere un caffè?",audio:appConstants.serverURL+"IT-Coq-08.mp3"},
			{castellano:"¿Te llevo/acompaño a tu casa?",idioma:"Posso accompagnarti a casa a pied/in macchina? ",audio:appConstants.serverURL+"IT-Coq-09.mp3"},
			{castellano:"¡Me lo pasé muy bien! ¡Buenas noches!",idioma:"Grazie per questa bellissima serata! Dormi bene!",audio:appConstants.serverURL+"IT-Coq-10.mp3"},
			{castellano:"Eres muy divertido/a",idioma:"Sei troppo forte!",audio:appConstants.serverURL+"IT-Coq-11.mp3"},
			{castellano:"Bailas muy bien!",idioma:"Sei un bravo ballerino/una brava ballerina!",audio:appConstants.serverURL+"IT-Coq-12.mp3"},
			{castellano:"Ha sido un gusto hablar contigo",idioma:"E’ stato un piacere parlare con te",audio:appConstants.serverURL+"IT-Coq-13.mp3"},
			{castellano:"No estoy interesado/a",idioma:"Non sono interessato/a",audio:appConstants.serverURL+"IT-Coq-14.mp3"},
			{castellano:"Déjame en paz",idioma:"Lasciami in pace",audio:appConstants.serverURL+"IT-Coq-15.mp3"}
			]
	}
]
}

var portugues=  {
		info:[
{
	apartado: "Básicas",
	nFilas: 23,
	lineas:[
			
			{castellano:"¿Podría ayudarme?",idioma:"Você pode me ajudar, por favor?",audio:appConstants.serverURL+"PT-Bas-01.mp3"},
			{castellano:"No entiendo",idioma:"Eu não compreendo",audio:appConstants.serverURL+"PT-Bas-02.mp3"},
			{castellano:"Hola",idioma:"Olá/oi ",audio:appConstants.serverURL+"PT-Bas-03.mp3"},
			{castellano:"Buenos días",idioma:"Bom dia",audio:appConstants.serverURL+"PT-Bas-04.mp3"},
			{castellano:"Buenas tardes",idioma:"Boa tarde",audio:appConstants.serverURL+"PT-Bas-05.mp3"},
			{castellano:"Buenas noches",idioma:"Boa noite",audio:appConstants.serverURL+"PT-Bas-06.mp3"},
			{castellano:"¿Cómo estás?",idioma:"Come voê está?",audio:appConstants.serverURL+"PT-Bas-07.mp3"},
			{castellano:"Bien, gracias",idioma:"Bem, obrigado/obrigada",audio:appConstants.serverURL+"PT-Bas-08.mp3"},
			{castellano:"¿Cómo te llamas?",idioma:"Como você se chama?",audio:appConstants.serverURL+"PT-Bas-09.mp3"},
			{castellano:"Me llamo… ",idioma:"Meu nome é…..",audio:appConstants.serverURL+"PT-Bas-10.mp3"},
			{castellano:"¿De qué país vienes? ",idioma:"De onde você è?",audio:appConstants.serverURL+"PT-Bas-11.mp3"},
			{castellano:"Soy de…",idioma:"Eu sou do…..",audio:appConstants.serverURL+"PT-Bas-12.mp3"},
			{castellano:"¿Cuántos años tienes?",idioma:"Quantos anos você tem?",audio:appConstants.serverURL+"PT-Bas-13.mp3"},
			{castellano:"Tengo … años",idioma:"Eu tenho….anos",audio:appConstants.serverURL+"PT-Bas-14.mp3"},
			{castellano:"Sí",idioma:"Sim",audio:appConstants.serverURL+"PT-Bas-15.mp3"},
			{castellano:"No",idioma:"Não",audio:appConstants.serverURL+"PT-Bas-16.mp3"},
			{castellano:"Por favor",idioma:"Por favor",audio:appConstants.serverURL+"PT-Bas-17.mp3"},
			{castellano:"Muchas  gracias",idioma:"Muito Obrigado/ obrigada ",audio:appConstants.serverURL+"PT-Bas-18.mp3"},
			{castellano:"De nada",idioma:"De nada",audio:appConstants.serverURL+"PT-Bas-19.mp3"},
			{castellano:"Lo siento",idioma:"Desculpa",audio:appConstants.serverURL+"PT-Bas-20.mp3"},
			{castellano:"Disculpe ",idioma:"Com licença",audio:appConstants.serverURL+"PT-Bas-21.mp3"},
			{castellano:"Fue un placer conocerte",idioma:"Prazer em cohencê-lo/la",audio:appConstants.serverURL+"PT-Bas-22.mp3"},
			{castellano:"Adiós ",idioma:"Tchau",audio:appConstants.serverURL+"PT-Bas-23.mp3"}
			
		]
},{
			
	apartado: "Salud",
	nFilas: 13,
	lineas:[
			{castellano:"Necesito ir al hospital",idioma:"Eu preciso ir ao hospital",audio:appConstants.serverURL+"PT-Sal-01.mp3"},
			{castellano:"Me siento mal",idioma:"Me sinto doente",audio:appConstants.serverURL+"PT-Sal-02.mp3"},
			{castellano:"Necesito ver a un doctor inmediatamente",idioma:"Eu preciso ir ao médico imediatamente",audio:appConstants.serverURL+"PT-Sal-03.mp3"},
			{castellano:"Ayuda",idioma:"Ajuda",audio:appConstants.serverURL+"PT-Sal-04.mp3"},
			{castellano:"Llamen a una ambulancia",idioma:"Chame uma ambulancia",audio:appConstants.serverURL+"PT-Sal-05.mp3"},
			{castellano:"Me duele aquí",idioma:"Dói aquí",audio:appConstants.serverURL+"PT-Sal-06.mp3"},
			{castellano:"Tengo fiebre",idioma:"Estou com febre",audio:appConstants.serverURL+"PT-Sal-07.mp3"},
			{castellano:"Tengo un resfriado",idioma:"Estou resfriado",audio:appConstants.serverURL+"PT-Sal-08.mp3"},
			{castellano:"¿Cuántas veces al día debo tomar esto?",idioma:"Quantas vezes a odia eu devo tomar ese remédio?",audio:appConstants.serverURL+"PT-Sal-09.mp3"},
			{castellano:"Me siento un poco mejor",idioma:"Sinto-me um pouco melhor",audio:appConstants.serverURL+"PT-Sal-10.mp3"},
			{castellano:"Ha empeorado",idioma:"Estou me sentindo pior",audio:appConstants.serverURL+"PT-Sal-11.mp3"},
			{castellano:"Está igual que antes",idioma:"Estou como antes",audio:appConstants.serverURL+"PT-Sal-12.mp3"},
			{castellano:"Tengo tos",idioma:"Estou com tosse",audio:appConstants.serverURL+"PT-Sal-13.mp3"}
										
			]
},{
		
	apartado: "Compras",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Cuánto cuesta?",idioma:"Quanto custa isso?",audio:appConstants.serverURL+"PT-Com-01.mp3"},
			{castellano:"¿Tiene algo que sea más barato?",idioma:"Você tem alguma coisa mais barata?",audio:appConstants.serverURL+"PT-Com-02.mp3"},
			{castellano:"¿A qué hora abre/cierra?",idioma:"Que horas você abre/fecha?",audio:appConstants.serverURL+"PT-Com-03.mp3"},
			{castellano:"Sólo estoy mirando",idioma:"Estou apenas olhando",audio:appConstants.serverURL+"PT-Com-04.mp3"},
			{castellano:"Lo compro",idioma:"Eu vou levar",audio:appConstants.serverURL+"PT-Com-05.mp3"},
			{castellano:"¿Me puede dar una bolsa, por favor?",idioma:"Você pode me dar uma sacola, por favor?",audio:appConstants.serverURL+"PT-Com-06.mp3"},
			{castellano:"Me gustaría devolver esto",idioma:"Eu gostaria devolver isso",audio:appConstants.serverURL+"PT-Com-07.mp3"},
			{castellano:"¿Dónde se encuentran los probadores?",idioma:"Onde estão os provadores?",audio:appConstants.serverURL+"PT-Com-08.mp3"}
			
			]
},{
			
	apartado: "Comer",
	nFilas: 7,
	lineas:[
			{castellano:"Me gustaría reservar una mesa para … personas a las …",idioma:"Eu gostaria reservar uma mesa para… ás…",audio:appConstants.serverURL+"PT-Salircomer-01.mp3"},
			{castellano:"¿Puedo ver el menú?",idioma:"Posso ver o cardápio, por favor?",audio:appConstants.serverURL+"PT-Salircomer-02.mp3"},
			{castellano:"Disculpe, nos gustaría pedir",idioma:"Com licença. Nos gostaríamos de fazer o pedido por favor",audio:appConstants.serverURL+"PT-Salircomer-03.mp3"},
			{castellano:"Nos gustaría pagar la cuenta",idioma:"Nós gostaríamos de pagar, por favor",audio:appConstants.serverURL+"PT-Salircomer-04.mp3"},
			{castellano:"Quédese con el cambio",idioma:"Pode ficar com o troco",audio:appConstants.serverURL+"PT-Salircomer-05.mp3"},
			{castellano:"La comida estuvo deliciosa",idioma:"A comida estava deliciosa",audio:appConstants.serverURL+"PT-Salircomer-06.mp3"},
			{castellano:"Yo no pedí esto",idioma:"Eu não pedi isso",audio:appConstants.serverURL+"PT-Salircomer-07.mp3"}
			
			]
},{
			
	apartado: "Hospedaje",
	nFilas: 8,
	lineas:[	
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Onde eu posso encontrar…?",audio:appConstants.serverURL+"PT-Hos-01.mp3"},
			{castellano:"¿Tiene habitaciones disponibles?",idioma:"Você tem algum quarto vago?",audio:appConstants.serverURL+"PT-Hos-02.mp3"},
			{castellano:"¿Cuál es el precio de una habitación para … personas?",idioma:"Quanto custa um quarto para….pessoa/pessoas?",audio:appConstants.serverURL+"PT-Hos-03.mp3"},
			{castellano:"Me gustaría reservar",idioma:"Eu gostaria de reservar",audio:appConstants.serverURL+"PT-Hos-04.mp3"},
			{castellano:"¿El desayuno está incluido?",idioma:"O cfé da manhã está incluido?",audio:appConstants.serverURL+"PT-Hos-05.mp3"},
			{castellano:"No hay agua caliente",idioma:"Não tem agua quente",audio:appConstants.serverURL+"PT-Hos-06.mp3"},
			{castellano:"El aire acondicionado no funciona",idioma:"O ar-condicionado não funciona",audio:appConstants.serverURL+"PT-Hos-07.mp3"},
			{castellano:"Mi llave no funciona",idioma:"Mina chave não funciona",audio:appConstants.serverURL+"PT-Hos-08.mp3"}
			
			]
},/*{
			
	apartado: "Números",
	nFilas: 12,
	lineas:[		
			{castellano:"Uno",idioma:"Um",audio:appConstants.serverURL+"PT-Num-01.mp3"},
			{castellano:"Dos",idioma:"Dois",audio:appConstants.serverURL+"PT-Num-02.mp3"},
			{castellano:"Tres ",idioma:"Três",audio:appConstants.serverURL+"PT-Num-03.mp3"},
			{castellano:"Cuatro",idioma:"Quatro",audio:appConstants.serverURL+"PT-Num-04.mp3"},
			{castellano:"Cinco",idioma:"Cinco",audio:appConstants.serverURL+"PT-Num-05.mp3"},
			{castellano:"Seis",idioma:"Seis",audio:appConstants.serverURL+"PT-Num-06.mp3"},
			{castellano:"Siete",idioma:"Sete",audio:appConstants.serverURL+"PT-Num-07.mp3"},
			{castellano:"Ocho",idioma:"Oito",audio:appConstants.serverURL+"PT-Num-08.mp3"},
			{castellano:"Nueve",idioma:"Nove",audio:appConstants.serverURL+"PT-Num-09.mp3"},
			{castellano:"Diez",idioma:"Dez",audio:appConstants.serverURL+"PT-Num-10.mp3"},
			{castellano:"Cien",idioma:"Cem",audio:appConstants.serverURL+"PT-Num-11.mp3"},
			{castellano:"Millón ",idioma:"Milhão/milhões",audio:appConstants.serverURL+"PT-Num-12.mp3"}
			
			]
},*/{
			
	apartado: "Viajar",
	nFilas: 11,
	lineas:[			
			{castellano:"Estoy perdido",idioma:"Eu estou perdido (a)",audio:appConstants.serverURL+"PT-Via-01.mp3"},
			{castellano:"¿Me puede mostrar su ubicación en el mapa?",idioma:"Você pode me mostrar onde è isso no mapa?",audio:appConstants.serverURL+"PT-Via-02.mp3"},
			{castellano:"¿Dónde puedo encontrar …?",idioma:"Onde eu encontró….",audio:appConstants.serverURL+"PT-Via-03.mp3"},
			{castellano:"¿Cómo llego a …?",idioma:"Como eu façco para chegar…?",audio:appConstants.serverURL+"PT-Via-04.mp3"},
			{castellano:"Gire a la izquierda ",idioma:"Vire á esquerda",audio:appConstants.serverURL+"PT-Via-05.mp3"},
			{castellano:"Gire a la derecha",idioma:"Vire á direita",audio:appConstants.serverURL+"PT-Via-06.mp3"},
			{castellano:"Siga derecho",idioma:"Siga em frente",audio:appConstants.serverURL+"PT-Via-07.mp3"},
			{castellano:"Regrese",idioma:"Volte",audio:appConstants.serverURL+"PT-Via-08.mp3"},
			{castellano:"¿Dónde puedo comprar un ticket para el autobús/tren?",idioma:"Onde eu posso comprar uma passage de ônibus/trem?",audio:appConstants.serverURL+"PT-Via-09.mp3"},
			{castellano:"¿Está ocupado este asiento?",idioma:"Este lugar está ocupado?",audio:appConstants.serverURL+"PT-Via-10.mp3"},
			{castellano:"Ese es mi asiento",idioma:"Este é o meu assento",audio:appConstants.serverURL+"PT-Via-11.mp3"}
			
			]
},{	
	apartado: "Quejas",
	nFilas: 5,
	lineas:[
			{castellano:"Me gustaría realizar una queja",idioma:"Eu gostaria fazer uma reclamação",audio:appConstants.serverURL+"PT-Que-01.mp3"},
			{castellano:"¿Quién es el encargado?",idioma:"Quem é o responsável aqui?",audio:appConstants.serverURL+"PT-Que-02.mp3"},
			{castellano:"Esto es totalmente inaceptable",idioma:"Isso é totalmente inaceitável",audio:appConstants.serverURL+"PT-Que-03.mp3"},
			{castellano:"Quiero mi dinero de vuelta",idioma:"Eu quero meu dinherio de volta",audio:appConstants.serverURL+"PT-Que-04.mp3"},
			{castellano:"Hemos estado esperando por más de una hora",idioma:"Estamos esperando há mais de uma hora",audio:appConstants.serverURL+"PT-Que-05.mp3"},					
		]
	 },{
			
	apartado: "Coqueteo",
	nFilas: 15,
	lineas:[					
			{castellano:"¿Te puedo invitar a algo para beber?",idioma:"Posso te pagar uma bebida?",audio:appConstants.serverURL+"PT-Coq-01.mp3"},
			{castellano:"¿A qué te dedicas?",idioma:"O que você faz na vida?",audio:appConstants.serverURL+"PT-Coq-02.mp3"},
			{castellano:"¿Quieres bailar?",idioma:"Você gostaria de asistir um filme na mina casa?",audio:appConstants.serverURL+"PT-Coq-03.mp3"},
			{castellano:"¿Te gustaría salir un poco?",idioma:"Você quer dançar?",audio:appConstants.serverURL+"PT-Coq-04.mp3"},
			{castellano:"¿Vamos a mi casa o a la tuya?",idioma:"Você gostaria de tomar um pouco de ar fresco?",audio:appConstants.serverURL+"PT-Coq-05.mp3"},
			{castellano:"¿Te gustaría ver una película en mi casa?",idioma:"Na mina casa ou na sua?",audio:appConstants.serverURL+"PT-Coq-06.mp3"},
			{castellano:"¿Tienes algún plan para esta noche?",idioma:"Você tem planos para hoje a noite?",audio:appConstants.serverURL+"PT-Coq-07.mp3"},
			{castellano:"¿Te gustaría ir a tomar un café?",idioma:"Você gostaria de ir tomar um café?",audio:appConstants.serverURL+"PT-Coq-08.mp3"},
			{castellano:"¿Te llevo/acompaño a tu casa?",idioma:"Posso te acompanhar até em casa?",audio:appConstants.serverURL+"PT-Coq-09.mp3"},
			{castellano:"¡Me lo pasé muy bien! ¡Buenas noches!",idioma:"Obrigado/ obrigada pela ótima tarde!tenha uma boa noite",audio:appConstants.serverURL+"PT-Coq-10.mp3"},
			{castellano:"Eres muy divertido/a",idioma:"Você é engraçado/engraçada",audio:appConstants.serverURL+"PT-Coq-11.mp3"},
			{castellano:"Bailas muy bien!",idioma:"Você é um ótimo dançarino/uma ótima dançarina",audio:appConstants.serverURL+"PT-Coq-12.mp3"},
			{castellano:"Ha sido un gusto hablar contigo",idioma:"É muito bom conversar com você",audio:appConstants.serverURL+"PT-Coq-13.mp3"},
			{castellano:"No estoy interesado/a",idioma:"Eu não estou interesado/interessada",audio:appConstants.serverURL+"PT-Coq-14.mp3"},
			{castellano:"Déjame en paz",idioma:"Deixe-me sozinho/sozinha",audio:appConstants.serverURL+"PT-Coq-15.mp3"}
			]
			
				}
]
}
		
var page = {
		create: function(db) {
			var contentDiv=null;
			var headerDiv=null;
			var lineas=null;

			var pageDiv=$('<div data-role="page" id="Tablas"></div>');

			var headerDiv=
				'<div data-role="header" data-position="fixed" data-theme="b" >'+
					'<a onclick="elegir_expresiones ()" class="ui-btn ui-btn-inline ui-btn-icon-left ui-icon-back">Atrás</a>'+
					'<h1 id="titulo_tablas" align="center" style="margin-left:0;margin-right:0;white-space: nowrap;overflow: visible;"></h1>'+
				'</div>';
			
			lineas="";
			
			if(pais=="Inglaterra")
			{
				for(var i=0;i<ingles.info[nApartado].nFilas;i++)
				{
					lineas+='<tr>'+
						'<td id="a-'+i+'castellano"></td>'+
						'<td id="a-'+i+'idioma"></td>'+
						'<td id="a-'+i+'audio"><a data-role="button" href="#popup'+i+'" data-rel="popup" data-iconpos="left" data-inline="true" data-icon="audio" data-transition="pop" class="ui-alt-icon.ui-icon-audio">audio</a></td>'+
					'</tr>'+
					
					'<div data-role="popup" id="popup'+i+'">'+
			        	'<audio controls>'+
			  				'<source id="audio'+i+'" src="" type="audio/wav">'+
						'</audio>'+
					'</div>'
				}
					
				var contentDiv=
					'<div data-role="content">'+
						'<table id="tabla_expresiones" class="table" border="3">'+
							'<thead>'+
								'<tr>'+
									'<th>Castellano</th>'+
									'<th>'+pais+'</th>'+
									'<th>Audio</th>'+
								'</tr>'+
							'</thead><tbody>'+
							lineas+
							'</tbody>'+
						'</table>'+
					'</div>';
			}
			else
			{
				for(var i=0;i<aleman.info[nApartado].nFilas;i++)
				{
					lineas+='<tr>'+
						'<td id="a-'+i+'castellano"></td>'+
						'<td id="a-'+i+'idioma"></td>'+
						'<td id="a-'+i+'audio"><a data-role="button" href="#popup'+i+'" data-rel="popup" data-iconpos="left" data-inline="true" data-icon="audio" data-transition="pop" class="ui-alt-icon.ui-icon-audio">audio</a></td>'+
					'</tr>'+
					
					'<div data-role="popup" id="popup'+i+'">'+
			        	'<audio controls>'+
			  				'<source id="audio'+i+'" src="" type="audio/mpeg">'+
						'</audio>'+
					'</div>'
				}
					
				var contentDiv=
					'<div data-role="content">'+
						'<table id="tabla_expresiones" class="table" border="3">'+
							'<thead>'+
								'<tr>'+
									'<th>Castellano</th>'+
									'<th>'+pais+'</th>'+
									'<th>Audio</th>'+
								'</tr>'+
							'</thead><tbody>'+
							lineas+
							'</tbody>'+
						'</table>'+
					'</div>';
			}
			 
			pageDiv.append(headerDiv,contentDiv);
			
			return pageDiv;
			
		},
		
		load: function()
		{
			//nApartado define el nº de apartado que se va a coger. Ej salud=1, numeros=3, etc...
			if(nApartado!=8)
			{
				switch (pais)
				{
					case 'Inglaterra': 
						$("#titulo_tablas").text(ingles.info[nApartado].apartado);
						for(var i=0;i<ingles.info[nApartado].nFilas;i++)
						{
							$("#a-"+i+"castellano").text(ingles.info[nApartado].lineas[i].castellano);   
				     		$("#a-"+i+"idioma").text(ingles.info[nApartado].lineas[i].idioma);
				    		$("#audio"+i).attr("src",ingles.info[nApartado].lineas[i].audio);
	
				     	};
						break;
							
					case 'Francia':
						$("#titulo_tablas").text(frances.info[nApartado].apartado);
						for(var i=0;i<frances.info[nApartado].nFilas;i++)
						{
							$("#a-"+i+"castellano").text(frances.info[nApartado].lineas[i].castellano);   
				     		$("#a-"+i+"idioma").text(frances.info[nApartado].lineas[i].idioma);
				    		$("#audio"+i).attr("src",frances.info[nApartado].lineas[i].audio);
			     		};
						break;
							
					case 'Alemania': ;
						$("#titulo_tablas").text(aleman.info[nApartado].apartado);
						for(var i=0;i<aleman.info[nApartado].nFilas;i++)
						{	
							$("#a-"+i+"castellano").text(aleman.info[nApartado].lineas[i].castellano);   
				     		$("#a-"+i+"idioma").text(aleman.info[nApartado].lineas[i].idioma);
				    		$("#audio"+i).attr("src",aleman.info[nApartado].lineas[i].audio);
			     		};
						break;
							
					case 'Italia':
						$("#titulo_tablas").text(italiano.info[nApartado].apartado);
						for(var i=0;i<italiano.info[nApartado].nFilas;i++)
						{
							$("#a-"+i+"castellano").text(italiano.info[nApartado].lineas[i].castellano);   
				     		$("#a-"+i+"idioma").text(italiano.info[nApartado].lineas[i].idioma);
				    		$("#audio"+i).attr("src",italiano.info[nApartado].lineas[i].audio);
			     		};
						break;
							
					case 'Portugal': 
						$("#titulo_tablas").text(portugues.info[nApartado].apartado);
						for(var i=0;i<portugues.info[nApartado].nFilas;i++)
						{
							$("#a-"+i+"castellano").text(portugues.info[nApartado].lineas[i].castellano);
				     		$("#a-"+i+"idioma").text(portugues.info[nApartado].lineas[i].idioma);
				    		$("#audio"+i).attr("src",portugues.info[nApartado].lineas[i].audio);
			     		};
						break;
				}
			}
	}
};



/********************************************* BASE DE DATOS *******************************************************************/

var pageDB = {
		create: function(datosCastellano,datosIdioma,datosAudio) {
			var contentDiv=null;
			var headerDiv=null;
			var lineas=null;

			var pageDiv=$('<div data-role="page" id="Tablas"></div>');

			var headerDiv=
				'<div data-role="header" data-position="fixed" data-theme="b" >'+
					'<a onclick="elegir_expresiones ()" class="ui-btn ui-btn-inline ui-btn-icon-left ui-icon-back">Atrás</a>'+
					'<h1 id="titulo_tablas" align="center" style="margin-left:0;margin-right:0;white-space: nowrap;overflow: visible;"></h1>'+
				'</div>';
			
			lineas="";
			
			if(pais=="Inglaterra")
			{
				for(var i=0;i<12;i++)
				{
					lineas+='<tr>'+
						'<td id="a-'+i+'castellano"></td>'+
						'<td id="a-'+i+'idioma"></td>'+
						'<td id="a-'+i+'audio"><a data-role="button" href="#popup'+i+'" data-rel="popup" data-iconpos="left" data-inline="true" data-icon="audio" data-transition="pop" class="ui-alt-icon.ui-icon-audio">audio</a></td>'+
					'</tr>'+
					
					'<div data-role="popup" id="popup'+i+'">'+
			        	'<audio controls>'+
			  				'<source id="audio'+i+'" src="" type="audio/wav">'+
						'</audio>'+
					'</div>'
				}
					
				var contentDiv=
					'<div data-role="content">'+
						'<table id="tabla_expresiones" class="table" border="3">'+
							'<thead>'+
								'<tr>'+
									'<th>Castellano</th>'+
									'<th>'+pais+'</th>'+
									'<th>Audio</th>'+
								'</tr>'+
							'</thead><tbody>'+
							lineas+
							'</tbody>'+
						'</table>'+
					'</div>';
			}
			else
			{
				for(var i=0;i<12;i++)
				{
					lineas+='<tr>'+
						'<td id="a-'+i+'castellano"></td>'+
						'<td id="a-'+i+'idioma"></td>'+
						'<td id="a-'+i+'audio"><a data-role="button" href="#popup'+i+'" data-rel="popup" data-iconpos="left" data-inline="true" data-icon="audio" data-transition="pop" class="ui-alt-icon.ui-icon-audio">audio</a></td>'+
					'</tr>'+
					
					'<div data-role="popup" id="popup'+i+'">'+
			        	'<audio controls>'+
			  				'<source id="audio'+i+'" src="" type="audio/mpeg">'+
						'</audio>'+
					'</div>'
				}
					
				var contentDiv=
					'<div data-role="content">'+
						'<table id="tabla_expresiones" class="table" border="3">'+
							'<thead>'+
								'<tr>'+
									'<th>Castellano</th>'+
									'<th>'+pais+'</th>'+
									'<th>Audio</th>'+
								'</tr>'+
							'</thead><tbody>'+
							lineas+
							'</tbody>'+
						'</table>'+
					'</div>';
			}
			 
			pageDiv.append(headerDiv,contentDiv);
			
			return pageDiv;	
		},
		
		load: function(datosCastellano,datosIdioma,datosAudio)
		{
			$("#titulo_tablas").text("Números");
			for(var i=0;i<12;i++)
			{
				$("#a-"+i+"castellano").text(datosCastellano[i]);   
	     		$("#a-"+i+"idioma").text(datosIdioma[i]);
	    		$("#audio"+i).attr("src",appConstants.serverURL+datosAudio[i]);
	
	     	};
		}
};