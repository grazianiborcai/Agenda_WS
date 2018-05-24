package br.com.gda.business.material.model.decisionTree;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatActionInsert implements DeciAction<MatInfo> {
	private final boolean SUCCESS = true;
	
	DeciAction<MatInfo> actionOneAttr;	
	DeciAction<MatInfo> actionTwoText;
	DeciAction<MatInfo> actionThreeSelec;
	DeciTreeOption<MatInfo> actionOption;
	
	public MatActionInsert(DeciTreeOption<MatInfo> option) {
		actionOption = option;
		buildActionOne();
	}
	
	
	
	private void buildActionOne() {
		actionOneAttr = new MatAttrActionInsert(actionOption);
	}
	
	
	
	@Override public boolean executeAction() {			
		boolean result = actionOneAttr.executeAction();
		
		if (result == SUCCESS)
			return forwardAction();
		
		return result;
	}
	
	
	
	private boolean forwardAction() {
		boolean result = forwardActionTwo();
		
		if (result == SUCCESS)
			return forwardActionThree();
		
		return result;
	}
	
	
	
	private boolean forwardActionTwo() {
		prepareOption();
		buildSecondTwo();
		return executeActionTwo();
	}
	
	
	
	private void prepareOption() {
		actionOption.recordInfos = actionOneAttr.getDecisionResult().getResultset();
	}
	
	
	
	private void buildSecondTwo() {
		actionTwoText = new MatTextActionInsert(actionOption);
	}
	
	
	
	private boolean executeActionTwo() {
		return actionTwoText.executeAction();
	}
	
	
	
	private boolean forwardActionThree() {
		prepareOption();
		buildSecondThree();
		return executeActionThree();
	}
	
	
	
	private void buildSecondThree() {
		actionThreeSelec = new MatActionSelect(actionOption);
	}
	
	
	
	private boolean executeActionThree() {
		return actionThreeSelec.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		if (actionThreeSelec != null)
			return actionThreeSelec.getDecisionResult();
		
		if (actionTwoText != null)
			return actionTwoText.getDecisionResult();
		
		return actionOneAttr.getDecisionResult();
	}
}
