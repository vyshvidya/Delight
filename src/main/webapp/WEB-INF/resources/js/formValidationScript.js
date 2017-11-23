$(function() 
{
	$("#registerForm").validate({
		rules : {
			name : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			
			password : {
				required : true,
				minlength : 3,
				maxlength : 10
			},
			phone : {
				required : true,
				minlength : 10,
				maxlength : 10
			},
			address : {
				required : true
			},
			country : {
				required : true
			},
			Doorno : {
				required : true
			},
			city : {
				required : true
			},
			streetname : {
				required : true
			},
			state : {
				required : true
			},
			Zipcode : {
				required : true
			},
		},
		messages : {
			name : {
				required : "Please enter your name"
			},
			email : {
				required : "Please enter your email",
				email : "Please enter valid email"
			},
			username : {
				required : "Please enter username"
			},
			password : {
				required : "Please enter password",
				minlength : "Your password must be between 3 and 10 characters",
				maxlength : "Your password must between 3 and 10 characters"
			},
			phone : {
				required : "Please enter the Phone No.",
				minlength : "Please enter valid 10 digit mobile number",
				maxlength : "Please enter valid 10 digit mobile number"
			},
			address : {
				required : "Please enter your address"
			},
			country : {
				required : "Please enter your country"
			},
			state: {
				required : "Please enter your state"
			},
			Doorno : {
				required : "Please enter your Door no"
			},
			streetname : {
				required : "Please enter your street name"
			},
			city : {
				required : "Please enter your city"
			},
			zipcode : {
				required : "Please enter your zipcode"
			},
			
		},
		submitHandler :function(form) {
			form.submit();
		}
	});
	
	
	
	
	
	
	$("#categoryForm").validate({
		rules : {
			catName : {
				required : true
			},
			catDesc : {
				required : true
			}
		},
		messages : {
			catName : {
				required : "Please enter category name"
			},
			catDesc : {
				required : "Please enter category description"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#supplierForm").validate({
		rules : {
			supplierName : {
				required : true
			},
			supplierAddress : {
				required : true
			},
			
		},
		messages : {
			supplierName : {
				required : "Please enter supplier name"
			},
			supplierAddress : {
				required : "Please enter supplier address"
			},
			
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
	$("#productForm").validate({
		rules : {
			productName : {
				required : true
			},
			price : {
				required : true,
				digits : true,
				min : 1
			},
			stock : {
				required : true,
				digits : true,
				min : 1
			},
			catId: {
				required: {
					depends: function(element) {
	                     return $('#catId').val() == 0;
	                 }
	              }
	        },
	        supplierId: {
				required: {
					depends: function(element) {
	                     return $('#supplierId').val() == 0;
	                 }
	              }
	        },
			productDesc : {
				required : true
			}
		},
		messages : {
			productName : {
				required : "Please enter product name"
			},
			price : {
				required : "Please enter product price",
				digits: "Please enter only digits",
				min: "Please enter valid product price"
			},
			stock : {
				required : "Please enter product stock",
				digits: "Please enter only digits",
				min: "Please enter valid product stock"
			},
			catId : {
				required : "Please choose a category"
			},
			supplierId : {
				required : "Please choose a supplier"
			},
			productDesc : {
				required : "Please enter product description"
			}
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	
});