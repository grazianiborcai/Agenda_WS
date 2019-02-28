package br.com.gda.model.common;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.model.ModelRequestChecker;
import br.com.gda.servlet.filter.common.HeaderParam;

public final class ModelRequestCheckerUsername extends ModelRequestChecker {

	public ModelRequestCheckerUsername(HttpServletRequest request) {
		super(request, HeaderParam.TOKEN_USERNAME, "username");
	}
}
