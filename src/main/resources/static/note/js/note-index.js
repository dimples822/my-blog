var navItems = document.querySelectorAll(".mobile-bottom-nav__item");
navItems.forEach(function (e) {
    e.addEventListener("click", function () {
        navItems.forEach(function (e2) {
            e2.classList.remove("mobile-bottom-nav__item--active");
        });
        this.classList.add("mobile-bottom-nav__item--active");
    });
});

document.getElementById("search-icon").onclick = function () {
    document.getElementById("circle-big").classList.toggle("change");
    document.getElementById("circle-small").classList.toggle("change");
    document.getElementById("line-left").classList.toggle("change");
    document.getElementById("line-right").classList.toggle("change");
    document.getElementById("full-search").classList.toggle("change");
    document.getElementById('full-search-text').focus();
    // window.setTimeout(function () { document.getElementById('full-search-text').focus(); }, 0);
};

/*
$("#note-add").click(function () {
    window.location.href = "notes/note-edit";
});*/
