package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, indexOfAllergicItem: Int, payment: Int): String {
        val BON_APPETIT = "Bon Appetit"

        validateInputData(bill, indexOfAllergicItem, payment)

        val personBillWithoutItem = getPersonBillWithoutItem(getBillWithoutAllergicItem(bill, indexOfAllergicItem))

        if (isPaymentEqualBill(payment, personBillWithoutItem)) {
            return BON_APPETIT
        }

        return refundAmountToString(payment, personBillWithoutItem)
    }

    private fun getBillWithoutAllergicItem(billList: IntArray, indexOfAllergicItem: Int): IntArray {
        val billListWithoutItem = billList.toMutableList()
        billListWithoutItem.remove(billList[indexOfAllergicItem])
        return billListWithoutItem.toIntArray()
    }

    private fun refundAmountToString( payment: Int, bill: Int): String {
        return (payment - bill).toString()
    }

    private fun getPersonBillWithoutItem(bill: IntArray): Int {
        return bill.sum() / 2
    }

    private fun isPaymentEqualBill(payment: Int, bill: Int): Boolean {
        return bill == payment
    }

    private fun validateInputData(bill: IntArray, indexOfAllergicItem: Int, payment: Int) {
        if (bill.isEmpty()) {
            throw NotImplementedError("Bill array is empty")
        }

        if (indexOfAllergicItem < 0 || indexOfAllergicItem >= bill.size) {
            throw NotImplementedError("Index '${indexOfAllergicItem}' of allergic item is out of bill array index [0, ..., ${bill.size - 1}]")
        }

        if (payment < 0) {
            throw NotImplementedError("Amount of paymaent '${payment}' could not be negative")
        }
    }
}

