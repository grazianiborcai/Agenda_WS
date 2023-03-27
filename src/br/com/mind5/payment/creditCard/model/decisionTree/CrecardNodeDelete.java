package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiDaoDelete;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiDaoUpdate;

public final class CrecardNodeDelete extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardNodeDelete(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<CrecardInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd <CrecardInfo> deleteMoip = new CrecardNodeMoipDelete(option).toAction();
		ActionStd <CrecardInfo> update     = new ActionStdCommom <CrecardInfo>(option, CrecardVisiDaoUpdate.class);
		ActionLazy<CrecardInfo> delete     = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiDaoDelete.class);
		
		update.addPostAction(delete);
		
		actions.add(deleteMoip);
		actions.add(update);		
		
		return actions;
	}
}
