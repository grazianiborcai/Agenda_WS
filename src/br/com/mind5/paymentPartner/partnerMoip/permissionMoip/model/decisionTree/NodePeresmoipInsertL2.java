package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipSuccess;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckExist;

public final class NodePeresmoipInsertL2 extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public NodePeresmoipInsertL2(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV1<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<PeresmoipInfo> insert = new StdPeresmoipInsert(option);	
		
		actions.add(insert);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PeresmoipInfo>> buildActionsOnFailedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV1<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<PeresmoipInfo> success = new StdPeresmoipSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
