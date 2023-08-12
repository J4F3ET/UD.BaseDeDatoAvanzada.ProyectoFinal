var containerPage = document.querySelector(".containerPage");
var pageNumber = 0;
nextPage();
loadMunicipios();
buttonsPages();
function loadMunicipios() {
	fetch("/municipio/findAll/public", {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			const municipioSelect = document.querySelector("#municipioSelectFiltro");
			console.log(municipioSelect);
			data.forEach((municipio) => {
				let option = document.createElement("option");
				option.value = municipio.id;
				option.text = municipio.nombre;
				municipioSelect.appendChild(option);
			});
		})
		.catch((error) => {
			console.error("Error fetching data:", error);
		});
}
function btnPage(boton) {
	document.querySelector(".btnActivePage").classList.remove("btn-primary");
	document.querySelector(".btnActivePage").classList.remove("btn-primary");
	document.querySelector(".btnActivePage").classList.add("btn-outline-primary");
	document.querySelector(".btnActivePage").classList.remove("btnActivePage");
	boton.classList.remove("btn-outline-primary");
	boton.classList.add("btn-primary");
	boton.classList.add("btnActivePage");
}
function btnGroupPage() {
	document.querySelector("#groupButtonControlPage").innerHTML = `
            <button type="button" class="buttonPage btn btn-outline-primary">${
							pageNumber - 1
						}</button>
            <button type="button" class="buttonPage btn btn-outline-primary">${pageNumber}</button>
            <button type="button" class="buttonPage btnActivePage btn btn-primary ">${
							pageNumber + 1
						}</button>
            <button type="button" class="buttonPage btn btn-outline-primary">${
							pageNumber + 2
						}</button>
            <button type="button" class="buttonPage btn btn-outline-primary">${
							pageNumber + 3
						}</button>
        `;
	buttonsPages();
}
function createRow(data, i) {
	var categoria1 = "";
	for (let j = 0; j < parseInt(data[i].categoria); j++) {
		categoria1 += `★`;
	}
	var categoria2 = "";
	for (let j = 0; j < parseInt(data[i + 1].categoria); j++) {
		categoria2 += `★`;
	}
	var containerRow = `<div class="containerRow">
                    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
                    <div class="rounded bg-body-tertiary w-100 me-md-3 pt-3 px-3 pt-md-5 px-md-5  text-center overflow-hidden" style="background-image: url(dist/img/img_background_card.jpg);">
                        <div class="my-3 p-3">
                        <h2 class="display-5">${data[i].nombre}</h2>
                        <p class="lead">${categoria1}</p>
                        <a class="text-black" href="#">Ver más</a>
                        </div>
                        <div class="bg-body shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;background-image: url(dist/img/habiatcion.jpg);"></div>
                    </div>
                    <div class="rounded bg-body-tertiary w-100 me-md-3 pt-3 px-3 pt-md-5 px-md-5  text-center overflow-hidden" style="background-image: url(dist/img/img_background_card.jpg);">
                        <div class="my-3 p-3">
                        <h2 class="display-5">${data[i + 1].nombre}</h2>
                        <p class="lead">${categoria2}</p>
                        <a class="text-black" href="#">Ver más</a>
                        </div>
                        <div class="bg-body shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;background-image: url(dist/img/habiatcion.jpg);"></div>
                    </div>
                    </div>
                </div>`;
	containerPage.innerHTML += containerRow;
}
function nextPage() {
	fetch(`/hotel/findAll/public?pageNumber=${pageNumber}`, {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((response) => response.json())
		.then((data) => {
			containerPage.innerHTML = "";
			for (let i = 0; i < data.length; i += 2) {
				createRow(data, i);
			}
		})
		.catch((error) => {
			console.error("Error fetching data:", error);
		});
	pageNumber += 1;
}
function buttonsPages() {
	document.querySelectorAll(".buttonPage").forEach((boton) =>
		boton.addEventListener("click", (event) => {
			event.preventDefault();
			btnPage(boton);
			pageNumber = parseInt(boton.innerHTML) - 1;
			if (pageNumber + 1 >= 3) {
				btnGroupPage();
			}
			nextPage();
			document.querySelector("#initA").click();
		})
	);
}
