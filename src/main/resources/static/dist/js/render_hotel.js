nextPage();
loadMunicipios();
//Paginacion
function findActivePage() {
	var currentPage = null;
	document.querySelectorAll(".btnPagination").forEach((element) => {
		if (element.parentElement.classList.contains("active")) {
			currentPage = element.parentElement;
		}
	});
	return currentPage;
}
function releasePageActive(elementLi) {
	if (elementLi.nextElementSibling == null) {
		releasePageBtnNext(elementLi);
	} else {
		releasePageBtnPrevious(elementLi);
	}
}
function releasePageBtnPrevious(elementLi) {
	const minValuePage = parseInt(
		elementLi.nextElementSibling.querySelector(".btnPagination").innerHTML
	);
	const currentPage = findActivePage();
	if (
		parseInt(currentPage.querySelector(".btnPagination").innerHTML) >
		minValuePage
	) {
		clearActivePage();
		currentPage.previousElementSibling.classList.add("active");
	} else if (
		parseInt(currentPage.querySelector(".btnPagination").innerHTML) != 1
	) {
		document.querySelectorAll(".btnPagination").forEach((element) => {
			element.innerHTML = parseInt(element.innerHTML) - 1;
		});
	}
}
function releasePageBtnNext(elementLi) {
	const maxValuePage = parseInt(
		elementLi.previousElementSibling.querySelector(".btnPagination").innerHTML
	);
	const currentPage = findActivePage();
	if (
		parseInt(currentPage.querySelector(".btnPagination").innerHTML) <
		maxValuePage
	) {
		clearActivePage();
		currentPage.nextElementSibling.classList.add("active");
	} else {
		document.querySelectorAll(".btnPagination").forEach((element) => {
			element.innerHTML = parseInt(element.innerHTML) + 1;
		});
	}
}
function clearActivePage() {
	document.querySelectorAll(".page-item").forEach((element) => {
		element.classList.remove("active");
	});
}
//Rederizar datos
function createRow(column1, column2) {
	const divContainerRow = document.createElement("div");
	divContainerRow.classList.add("containerRow");
	const divContainerFlex = document.createElement("div");
	divContainerFlex.classList.add(
		"d-md-flex",
		"flex-md-equal",
		"w-100",
		"my-md-3",
		"ps-md-3"
	);
	const divContainerItemExternal1 = createItemForRow(column1);
	divContainerFlex.appendChild(divContainerItemExternal1);
	if (column2 != null) {
		const divContainerItemExternal2 = createItemForRow(column2);
		divContainerFlex.appendChild(divContainerItemExternal2);
	}
	divContainerRow.appendChild(divContainerFlex);
	return divContainerRow;
}
function resolveCategory(category) {
	var starts = "";
	for (let j = 0; j < parseInt(category); j++) {
		starts += `★`;
	}
	return starts;
}
function createItemForRow(data) {
	const divContainerItemExternal = document.createElement("div");
	divContainerItemExternal.classList.add(
		"rounded",
		"bg-body-tertiary",
		"w-100",
		"me-md-3",
		"pt-3",
		"px-3",
		"pt-md-5",
		"px-md-5",
		"text-center",
		"overflow-hidden"
	);
	divContainerItemExternal.style.backgroundImage =
		"url(dist/img/img_background_card.jpg)";
	const divContainerItemInternal = document.createElement("div");
	divContainerItemInternal.classList.add("my-3", "p-3");
	const h2 = document.createElement("h2");
	h2.classList.add("display-5");
	h2.innerHTML = data.nombre;
	const p = document.createElement("p");
	p.classList.add("lead");
	p.innerHTML = resolveCategory(data.categoria);
	const a = document.createElement("a");
	a.classList.add("text-black");
	a.href = "#";
	a.innerHTML = "Ver más";
	const divContainerImage = document.createElement("div");
	divContainerImage.classList.add("bg-body", "shadow-sm", "mx-auto");
	divContainerImage.style.width = "80%";
	divContainerImage.style.height = "300px";
	divContainerImage.style.borderRadius = "21px 21px 0 0";
	divContainerImage.style.backgroundImage = "url(dist/img/habitacion.jpg)";
	divContainerItemInternal.appendChild(h2);
	divContainerItemInternal.appendChild(p);
	divContainerItemInternal.appendChild(a);
	divContainerItemExternal.appendChild(divContainerItemInternal);
	divContainerItemExternal.appendChild(divContainerImage);
	return divContainerItemExternal;
}
//Carga de datos
function loadMunicipios() {
	fetch("/municipio/findAll/public", {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((response) => response.json())
		.then((data) => {
			data.forEach((municipio) => {
				let option = document.createElement("option");
				option.value = municipio.id_municipio;
				option.text =
					municipio.nombre.substring(0, 1) +
					municipio.nombre.substring(1).toLowerCase();
				document.querySelector("#municipioSelectFiltro").appendChild(option);
			});
		})
		.catch((error) => {
			console.error("Error fetching data:", error);
		});
}
function clearNameHotel(data) {
	const aux = [
		"S.A.S.",
		" S.A.S",
		" S A S",
		"S.A.",
		"S A",
		"LTDA.",
		"LTDA",
		"LIMITADA",
		"REORGANIZACIÓN",
		"& CIA S.EN C.",
	];
	data.forEach((hotel) => {
		aux.forEach((element) => {
			hotel.nombre = hotel.nombre.replace(element, "");
		});
	});
	return data;
}
function nextPage(
	pageNumber = 0,
	municipioSelectFiltro = 0,
	categoriaSelectFiltro = 0
) {
	fetch(
		`/hotel/findAll/public?pageNumber=${pageNumber}&id_municipio=${municipioSelectFiltro}&categoria=${categoriaSelectFiltro}`,
		{
			method: "GET",
			headers: {
				"Content-Type": "application/json",
			},
		}
	)
		.then((response) => response.json())
		.then((data) => {
			data = clearNameHotel(data);
			var containerPage = document.querySelector(".containerPage");
			containerPage.innerHTML = "";
			for (let i = 0; i < data.length; i += 2) {
				containerPage.appendChild(createRow(data[i], data[i + 1]));
			}
		})
		.catch((error) => {
			console.error("Error fetch data:", error);
		});
	pageNumber += 1;
}
// Eventos
document.querySelectorAll(".page-item").forEach((elementLi) => {
	elementLi.addEventListener("click", (event) => {
		if (elementLi.firstElementChild.hasAttribute("aria-label")) {
			releasePageActive(elementLi);
			findActivePage().click();
		} else {
			clearActivePage();
			elementLi.classList.add("active");
			nextPage(
				parseInt(elementLi.querySelector(".btnPagination").innerHTML) - 1,
				parseInt(document.querySelector("#municipioSelectFiltro").value),
				parseInt(document.querySelector("#selectCategoriaFiltro").value)
			);
		}
	});
});
document.querySelectorAll(".selectFilter").forEach((select) => {
	select.addEventListener("change", (event) => {
		nextPage(
			parseInt(findActivePage().querySelector(".btnPagination").innerHTML) - 1,
			parseInt(document.querySelector("#municipioSelectFiltro").value),
			parseInt(document.querySelector("#selectCategoriaFiltro").value)
		);
	});
});
