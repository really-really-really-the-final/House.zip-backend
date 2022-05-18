$(function () {
 sendRequest("sido", "*00000000");
});

$(document).on("change", "#sido", function () {
  regcode = $(this).val().substr(0, 2) + "*00000";
  $("#gugun").empty();
  $("#dong").empty().append("<option>동선택</option>");
  sendRequest("gugun", regcode);
});

$(document).on("change", "#gugun", function () {
  regcode = $(this).val().substr(0, 5) + "*";
  sendRequest("dong", regcode);
});

function sendRequest(selid, regcode) {
  $.ajax({
    url: "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes",
    type: "GET",
    data: {
      regcode_pattern: regcode,
      is_ignore_zero: true,
    },
    dataType: "json",
    success: function (response) {
      addOption(selid, response);
    //화면 정보를 설정한다.
      setSearchCondition();
    },
    error: function (xhr, status, msg) {
      console.log("상태값 : " + status + " Http에러메시지 : " + msg);
    },
  });
}

function addOption(selid, data) {
  let code = ``;
  let initOption = ``;
  switch (selid) {
    case "sido":
      initOption = `<option>시도선택</option>`;
      $("#sido").empty().append(initOption);
      $.each(data.regcodes, function (i, regcode) {
        code += `<option value="${regcode.code}">${regcode.name.split(" ")[0]}</option>`;
      });
      break;
    case "gugun":
      initOption = `<option>구군선택</option>`;
      $("#gugun").empty().append(initOption);
      console.log(data.regcodes);
      for (let i = 0; i < data.regcodes.length; i++) {
        if (i != data.regcodes.length - 1) {
          if (
            data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
            data.regcodes[i].name.split(" ").length != data.regcodes[i + 1].name.split(" ").length
          ) {
            data.regcodes.splice(i, 1);
            i--;
          }
        }
      }
      //console.log(data.regcodes);
      let name = "";
      $.each(data.regcodes, function (i, regcode) {
        if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
        else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
//        if(${regcode.code}==${searchCondition.gugun})console.log("됨");
        code += `<option value="${regcode.code}">${name}</option>`;
      });
      break;
    case "dong":
      initOption = `<option>동선택</option>`;
      $("#dong").empty().append(initOption);
      let idx = 2;
      $.each(data.regcodes, function (i, regcode) {
        if (data.regcodes[i].name.split(" ").length != 3) idx = 3;
        code += `<option value="${regcode.code}">${
          regcode.name.split(" ")[idx]
        }</option>`;
      });
      break;
  }
  $("#" + selid).append(code);
}



//<select>요소에서 value 기준으로 <option>을 선택한다.
function selectOptionByValue(selectId, value){
	let select=document.querySelector("#"+selectId)
	let opts=select.options;
	for(let i=0; i<opts.length; i++){
		if (opts[i].value==value){
			select.selectedIndex=i;
			break;
		}
	}
}


//page를 이용해서 자료를 검색한다. 함수 호출은 paging.jsp에서 이뤄진다.
function movePage(page){
	// currentPage에 전달받은 page를 저장한다.
	document.querySelector("#currentPage").value=page;
	// searchForm을 submit 시킨다.
	document.querySelector("#searchForm").submit();
}


