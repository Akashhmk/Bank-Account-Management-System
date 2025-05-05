
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*") // Allow frontend access
public class BankAccountController {
    private BankAccount account = new BankAccount("123456789", "Akash", 1000.0);

    @GetMapping
    public BankAccount getDetails() {
        return account;
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam double amount) {
        try {
            account.deposit(amount);
            return ResponseEntity.ok("Deposited: ₹" + amount);
        } catch (InvalidDepositAmountException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam double amount) {
        try {
            account.withdraw(amount);
            return ResponseEntity.ok("Withdrawn: ₹" + amount);
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
