package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipNodeCode;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckCode;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckLangu;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckOwner;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckUsername;

public final class RootPeresmoipCode extends DeciTreeTemplateWrite<PeresmoipInfo> {
	
	public RootPeresmoipCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PeresmoipCheckCode(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PeresmoipCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> mergeToSelect = new StdPeresmoipMergeToSelect(option);	
		ActionLazy<PeresmoipInfo> nodeCode = new LazyPeresmoipNodeCode(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(nodeCode);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
