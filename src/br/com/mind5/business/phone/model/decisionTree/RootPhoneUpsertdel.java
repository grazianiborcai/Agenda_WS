package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.checker.PhoneCheckHasPhone;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPhoneUpsertdel extends DeciTreeTemplateWriteV2<PhoneInfo> {
	
	public RootPhoneUpsertdel(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelCheckerV1<PhoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckHasPhone(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStdV2<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PhoneInfo> nodeUpsertdel = new NodePhoneUpsertdel(option).toAction();
		
		actions.add(nodeUpsertdel);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStdV2<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PhoneInfo> insert = new RootPhoneInsert(option).toAction();
		
		actions.add(insert);	
		return actions;
	}
}
