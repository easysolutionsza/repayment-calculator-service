package org.toroue.repayment.calculator.utils;

public class ApplicationUtils {



    public Double calculateIntrest(Double principleAmount,Double roiPercent,Double termInYear )
    {
        Double simpleIntrest  = (principleAmount*roiPercent*termInYear)/100;
        return simpleIntrest;
    }
}
