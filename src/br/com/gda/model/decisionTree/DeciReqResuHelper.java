package br.com.gda.model.decisionTree;

import br.com.gda.common.SystemMessage;

public final class DeciReqResuHelper implements DeciReqResu {
	private DeciResult<?> result;
	private DeciResuTranslator translator;
	
	
	public DeciReqResuHelper(DeciResult<?> deciResult, DeciResuTranslator deciTranslator) {
		checkArgument(deciResult, deciTranslator);
		result = deciResult;
		translator = deciTranslator;
	}
	
	
	
	private void checkArgument(DeciResult<?> deciResult, DeciResuTranslator deciTranslator) {
		if (deciResult == null)
			throw new NullPointerException("deciResult" + SystemMessage.NULL_ARGUMENT);
		
		if (deciTranslator == null)
			throw new NullPointerException("deciTranslator" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public DeciResult<?> getResult() {
		return translator.translate(result);
	}
}
