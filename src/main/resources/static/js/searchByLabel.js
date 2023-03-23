const DivRows = document.querySelectorAll('.tr')
const search_value = document.querySelector('.search_input')
const form = document.getElementsByClassName("row");


function processTextInTable (text) {
	DivRows.forEach(row => {
		if (!row.innerHTML.includes(text)) {
			row.classList.add('visually-hidden')
		} else
		if (text.length > 1 && !row.innerHTML.includes(text)) {
			row.classList.add('visually-hidden')
		} else {
			row.classList.remove('visually-hidden')
		}
	})
}

function findTextInTable (url, text) {
	const api_url = url.split('#')[0]
	fetch(`${api_url}?searchValue=${text}`, {
		method: "GET",
		Accept: "application/json",
		'Content-Type': "application/json"
	}).then(response => {
		if (response.status === 200) {
			console.log("works")
			response.json().then(result => processTextInTable(text))
		}
	})
}


search_value.addEventListener('input', () => {
	let textValue = search_value.value;
	let uri = location.toString().split("/")
	let last_indexOfURI = uri[uri.length-1]
	//[uri.indexOf("/") + 1] will be useful another time
	let page = last_indexOfURI
	findTextInTable(`/api/${page}`, textValue)
})
