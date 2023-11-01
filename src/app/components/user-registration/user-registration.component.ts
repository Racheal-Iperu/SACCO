import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../services/users.service";

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private userService: UserService) {
  }

  formGroup: FormGroup | any

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      name: ['', [Validators.required]],
      mobile: ['', [Validators.required]],
      address: ['', [Validators.required]]
    })

  }

  register() {
    const formData = {
      studentname: this.formGroup.value.name,
      mobile: this.formGroup.value.mobile,
      studentaddress: this.formGroup.value.address
    }
    this.userService.createDocument(formData).subscribe({
      next: res => {
        console.log(res)
      },error: err =>{
      }
    })
  }
}
