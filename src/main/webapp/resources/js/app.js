$(document).ready(function() {
});

function onClickLink(selectedPageSize, pageId, nom) {
	if (nom == "null") {
		window.location.replace("/listPersons/?pageSize=" + selectedPageSize + "&page=" + pageId);
		return;
	}
	window.location.replace("/listPersons/?pageSize=" + selectedPageSize + "&page=" + pageId + "&nom=" + nom);
	return;
}

function onChangeSelect(pageId, nom) {
	return onClickLink($('#pageSizeSelect').val(), pageId, nom);
}