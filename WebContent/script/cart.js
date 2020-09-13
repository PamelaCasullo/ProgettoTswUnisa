let sessionId=$("#sessionid").val()
let totaleCarrello = 0;
let costo = 0;

window.onload = function () {
    const table = document.getElementById("data");
    table.innerHTML = '';
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = () => {
        if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState== 4 ) {
            let items = JSON.parse(xmlHttpRequest.responseText)
            riempiTabella(items, table)
            console.log(items)
            if(items.length >0) {
                document.getElementById('procedialpagamento').classList.remove('d-none')
            }
        }
        document.getElementById("totalecarrello").innerText = '${totaleCarrello}€' 
    }
    xmlHttpRequest.open("GET", 'CartServlet; jsessionid=${sessionID}?action=vedi', true)//action==vedi??
    xmlHttpRequest.send();
}

function refreshCarrello() {
    const table = document.getElementById("data");
    table.innerHTML='';
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = () => {
        if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState== 4 ) {
            let items = JSON.parse(xmlHttpRequest.responseText)
            riempiTabella(items, table)
            console.log(items)
            if(items.length >0) {
                document.getElementById('procedialpagamento').classList.remove('d-none')
            }
        }
    document.getElementById("totalecarrello").innerText = '${totaleCarrello}€' 
}
xmlHttpRequest.open("GET", 'CartServlet; jsessionid=${sessionID}?action=vedi', true)//action==vedi??
xmlHttpRequest.send();
}

const riempiTabella = (data, table) => {
    totaleCarrello = 0
    data.forEach((elemento => {

        const riga = document.createElement('tr')
        table.appendChild(riga);

        const nomeProdotto = document.createElement('td')
        nomeProdotto.innerText = elemento.sBean.nome_oggetto;
        riga.appendChild(nomeProdotto);
        const totaleProdotto = document.createElement('td')
        totaleProdotto.innerText = `${elemento.sBean.prezzo} € l'uno`
        riga.appendChild(totale)
        const elimina = document.createElement('td')
        riga.appendChild(elimina)
        const eliminaBtn = document.createElement('button')
        eliminaBtn.innerText = 'Elimina'
        eliminaBtn.classList.add('btn', 'btn-danger')
        eliminaBtn.addEventListener('click', () => eliminaDalCarrello(elemento))
        elimina.appendChild(eliminaBtn)
        totaleCarrello += elemento.sBean.prezzo;
    }))
}

function eliminaDalCarrello(elemento) {
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = () => {
        if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState ==4) {
            console.log('click')
            refreshCarrello();
        }
    }
    xmlHttpRequest.open("GET", 'CartServlet; jsessionid=${sessionID}?action=elimina&id_prodotto=${elemento.sBean.id}', true)
    xmlHttpRequest.send();
}