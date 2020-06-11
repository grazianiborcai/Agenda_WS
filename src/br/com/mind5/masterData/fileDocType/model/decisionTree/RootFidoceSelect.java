package br.com.mind5.masterData.fileDocType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.masterData.fileDocType.model.action.StdFidoceDaoSelect;
import br.com.mind5.masterData.fileDocType.model.checker.FidoceCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFidoceSelect extends DeciTreeTemplateReadV2<FidoceInfo> {
	
	public RootFidoceSelect(DeciTreeOption<FidoceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FidoceInfo> buildCheckerHook(DeciTreeOption<FidoceInfo> option) {
		List<ModelCheckerV1<FidoceInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FidoceInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FidoceCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FidoceInfo>> buildActionsOnPassedHook(DeciTreeOption<FidoceInfo> option) {
		List<ActionStdV1<FidoceInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FidoceInfo> select = new StdFidoceDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
