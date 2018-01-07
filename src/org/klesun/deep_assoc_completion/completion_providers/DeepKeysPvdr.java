package org.klesun.deep_assoc_completion.completion_providers;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.*;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.jetbrains.php.lang.psi.elements.ArrayAccessExpression;
import com.jetbrains.php.lang.psi.elements.ArrayIndex;
import com.jetbrains.php.lang.psi.elements.Variable;
import org.jetbrains.annotations.NotNull;

/**
 * contains the completion logic
 */
public class DeepKeysPvdr extends CompletionProvider<CompletionParameters>
{
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext processingContext, @NotNull CompletionResultSet result)
    {
        PsiElement literal = parameters.getPosition().getParent();
        if (literal == null) return;
        PsiElement indexRaw = literal.getParent();
        if (indexRaw == null || !(indexRaw instanceof ArrayIndex)) {
            return;
        }
        PsiElement accessRaw = indexRaw.getParent();
        if (accessRaw == null || !(accessRaw instanceof ArrayAccessExpression)) {
            return;
        }
        ArrayAccessExpression access = (ArrayAccessExpression) accessRaw;
        PsiElement varRaw = access.getValue();
        if (varRaw == null || !(varRaw instanceof Variable)) {
            return;
        }
        Variable var = (Variable) varRaw;

        // this line causes the PsiInvalidElementAccessException
        PsiElement declaration = var.resolve();
        result.addElement(LookupElementBuilder.create("resolved: " + declaration));
    }
}
