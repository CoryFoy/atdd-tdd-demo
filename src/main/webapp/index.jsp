<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/autonumeric@4.1.0"></script>
    <script type="text/javascript">
        // $(document).ready(function() {
        //     $(".amount-entry").change(function() {
        //         new AutoNumeric('#discounts-display', Math.random(), { currencySymbol : '$' });
        //         new AutoNumeric('#total-display', Math.random(), { currencySymbol : '$' });
        //     });
        // });
    </script>
</head>
<body>
<form action="/orderprocessor/process">
    <table border="1">
        <thead>
        <tr>
            <td>Description</td>
            <td>Amount</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" id="item1" class="item-entry"></td>
            <td><input type="text" id="amount1" class="amount-entry"></td>
        </tr>
        <tr>
            <td><input type="text" id="item2" class="item-entry"></td>
            <td><input type="text" id="amount2" class="amount-entry"></td>
        </tr>
        <tr>
            <td><input type="text" id="item3" class="item-entry"></td>
            <td><input type="text" id="amount3" class="amount-entry"></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td>DISCOUNTS</td>
            <td id="discounts-display"></td>
        </tr>
        <tr>
            <td>TOTAL</td>
            <td id="total-display"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Process Order</button></td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>