package br.com.mind5.model.common;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelRequestChecker;
import br.com.mind5.servlet.filter.common.HeaderParam;

public final class ModelRequestCheckerUsername extends ModelRequestChecker {

	public ModelRequestCheckerUsername(HttpServletRequest request) {
		super(request, HeaderParam.TOKEN_USERNAME, "username");
	}
}
