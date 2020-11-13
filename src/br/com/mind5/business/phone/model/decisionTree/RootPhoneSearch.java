package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneRootSelect;
import br.com.mind5.business.phone.model.action.StdPhoneMergePhonarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPhoneSearch extends DeciTreeTemplateWriteV2<PhoneInfo> {
	
	public RootPhoneSearch(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelCheckerV1<PhoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PhoneInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStdV1<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhoneInfo> mergePhonarch = new StdPhoneMergePhonarch(option);		
		ActionLazy<PhoneInfo> select = new LazyPhoneRootSelect(option.conn, option.schemaName);
		
		mergePhonarch.addPostAction(select);
		
		actions.add(mergePhonarch);			
		return actions;
	}
}
