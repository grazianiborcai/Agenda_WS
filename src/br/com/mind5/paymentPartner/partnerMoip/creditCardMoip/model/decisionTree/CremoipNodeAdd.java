package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiAdd;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiEnforceDocument;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiEnforceHolder;

public final class CremoipNodeAdd extends DeciTreeTemplateWrite<CremoipInfo> {
	
	public CremoipNodeAdd(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> enforceDocument = new ActionStdCommom<CremoipInfo>(option, CremoipVisiEnforceDocument.class);		
		ActionLazy<CremoipInfo> enforceHolder = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiEnforceHolder.class);
		ActionLazy<CremoipInfo> enforceCard = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiEnforceCard.class);
		ActionLazy<CremoipInfo> enforceFunding = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiEnforceFunding.class);
		ActionLazy<CremoipInfo> addCard = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiAdd.class);

		enforceDocument.addPostAction(enforceHolder);
		enforceHolder.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(addCard);
		
		actions.add(enforceDocument);
		return actions;
	}
}
