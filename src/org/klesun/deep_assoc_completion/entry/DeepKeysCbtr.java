package org.klesun.deep_assoc_completion.entry;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.lang.documentation.phpdoc.psi.tags.PhpDocParamTag;
import com.jetbrains.php.lang.psi.elements.*;
import com.jetbrains.php.lang.psi.elements.impl.ArrayHashElementImpl;
import com.jetbrains.php.lang.psi.elements.impl.PhpPsiElementImpl;
import org.jetbrains.annotations.NotNull;
import org.klesun.deep_assoc_completion.completion_providers.*;

/**
 * provides associative array keys autocomplete
 * using declaration inside the initial function
 * that created this array
 */
public class DeepKeysCbtr extends CompletionContributor
{
    public DeepKeysCbtr()
    {
        this.extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .withSuperParent(1, StringLiteralExpression.class)
                .withSuperParent(2, ArrayIndex.class),
            new DeepKeysPvdr()
        );
    }
}
