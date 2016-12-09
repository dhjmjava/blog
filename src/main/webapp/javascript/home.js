//"use strict"
    $("#totalCount").text(totalCount);
	
	$(".jump").each(function(){
		var j = $(this);
		if(parseInt(j.text()) == currPage){
			j.parent().attr("class","active");
		}
	})
	
	//上一页
	function pageUp(){
		if(currPage == 1){
			$("#pageUp").attr("class","disabled");
			return false;
		}
		$("#currPage").val(parseInt($("#currPage").val())-1);
		//window.location.href="/blog?currPage="+(currPage-1)+"&amp;pageSize="+pageSize;	
		$("#homeForm").submit();
	}

	//下一页
	function pageDown(){
		if(currPage == pageNumber){
			$("#pageDown").attr("class","disabled");
			return false;
		}
		$("#currPage").val( parseInt($("#currPage").val())+1);
		//window.location.href="/blog?currPage="+(currPage+1)+"&amp;pageSize="+pageSize;
		$("#homeForm").submit();
	}
	
	//尾页
	function pageEnd(){
		window.location.href="/blog?currPage="+pageNumber;
	}
	
	//跳页
	$(".jump").click(function(){
		var num = $(this).text();
		$("#currPage").val(num);
		$("#homeForm").submit();
	})
	
	var i=0;
	var j=0
	function typeSearch(fn){
		i++;
		if(i==1){
			$("#currPage").val(1);
		}
		var tid = $(fn).attr("tid");
		$("#typeId").val(tid);
		$("#searchDate").val('');
		$("#homeForm").submit();
	}
	
	function dateSearch(fn){
		j++;
		if(j==1){
			$("#currPage").val(1);
		}
		var month = $(fn).attr("month");
		$("#searchDate").val(month);
		$("#typeId").val(-1);
		$("#homeForm").submit();
	}
	
	//字数限制
	 $(function(){
		 $(".summary").each(function(){
				var maxwidth=800;
			    if($(this).text().length>maxwidth){
					$(this).html($(this).html().substring(0,maxwidth));
		         }
	       });
	 })