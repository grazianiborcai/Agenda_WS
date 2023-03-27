package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiCreate;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiEnforceMetadata;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiMergeCrecard;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action.CrecapaVisiMergeCuspar;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker.CrecapaCheckCreate;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker.CrecapaCheckCrecard;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker.CrecapaCheckCuspar;

public final class CrecapaRootCreate extends DeciTreeTemplateWrite<CrecapaInfo> {
	
	public CrecapaRootCreate(DeciTreeOption<CrecapaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecapaInfo> buildCheckerHook(DeciTreeOption<CrecapaInfo> option) {
		List<ModelChecker<CrecapaInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecapaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecapaCheckCreate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecapaCheckCuspar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecapaCheckCrecard(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecapaInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecapaInfo> option) {
		List<ActionStd<CrecapaInfo>> actions = new ArrayList<>();
		
		ActionStd <CrecapaInfo> mergeSetupar    = new CrecapaNodeSetuparL1(option).toAction();
		ActionLazy<CrecapaInfo> mergeCuspar     = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiMergeCuspar.class);
		ActionLazy<CrecapaInfo> mergeCrecard    = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiMergeCrecard.class);
		ActionLazy<CrecapaInfo> enforceMetadata = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiEnforceMetadata.class);
		ActionLazy<CrecapaInfo> create          = new ActionLazyCommom<CrecapaInfo>(option, CrecapaVisiCreate.class);
		
		mergeSetupar.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergeCrecard);
		mergeCrecard.addPostAction(enforceMetadata);
		enforceMetadata.addPostAction(create);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
